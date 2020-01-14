import java.util.*;
import java.io.*;
import java.math.*;

/**
 * SkynetRevolution : look for neighbourNodes in a graph
 **/
class SkynetRevolution {
    
    private int linksNumber;
    private List<Integer> linkFirstNodes;
    private List<Integer> linkSecondNodes;
    private int exitGatewaysNumber;
    private List<Integer> gatewaysNodes;

    public SkynetRevolution(int linksNumber, List<Integer> linkFirstNodes,
                  List<Integer> linkSecondNodes, int exitGatewaysNumber, List<Integer> gatewaysNodes)
    {
        this.linksNumber = linksNumber;
        this.linkFirstNodes = linkFirstNodes;
        this.linkSecondNodes = linkSecondNodes;
        this.exitGatewaysNumber = exitGatewaysNumber;
        this.gatewaysNodes = gatewaysNodes;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        
        List<Integer> linkFirstNodes = new ArrayList<Integer>();
        List<Integer> linkSecondNodes = new ArrayList<Integer>();
        List<Integer> gatewaysNodes = new ArrayList<Integer>();
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            linkFirstNodes.add(N1);
            linkSecondNodes.add(N2);
        }
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            gatewaysNodes.add(EI);
        }
        
        SkynetRevolution skynetRevolution = new SkynetRevolution(L, linkFirstNodes, linkSecondNodes, E, gatewaysNodes);

        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn
            skynetRevolution.lookPathSIandRemoveLink(SI);
        }
    }
    
    private boolean isGateway(int node) {
        for(int gatewayNodesIdx = 0; gatewayNodesIdx < gatewaysNodes.size(); gatewayNodesIdx++) {
            if(node == gatewaysNodes.get(gatewayNodesIdx)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isLinkFound(int firstNode, int secondNode, int linkIndex) {
        return (linkFirstNodes.get(linkIndex) == firstNode && linkSecondNodes.get(linkIndex) == secondNode) ||
                (linkFirstNodes.get(linkIndex) == secondNode && linkSecondNodes.get(linkIndex) == firstNode);
    }
    
    private void removeLink(int firstNode, int secondNode) {
        System.out.println(firstNode + " " + secondNode);
        int linkIdxToRemove = -1;
        for (int linkIdx = 0; linkIdx < linkFirstNodes.size(); linkIdx++) {
            if(isLinkFound(firstNode, secondNode, linkIdx)) {
                linkIdxToRemove = linkIdx;
            }
        }
        linksNumber--;
        linkFirstNodes.remove(linkIdxToRemove);
        linkSecondNodes.remove(linkIdxToRemove);
    }
    
    private List<Integer> getNeighbourNodes(int currentPosition) {
        List<Integer> neighbourNodes = new ArrayList<Integer>();
        
        for (int linkIdx = 0; linkIdx < linksNumber; linkIdx++) {
            if(currentPosition == linkFirstNodes.get(linkIdx)) {
               neighbourNodes.add(linkSecondNodes.get(linkIdx));
            }
            
            if (currentPosition == linkSecondNodes.get(linkIdx)) {
                neighbourNodes.add(linkFirstNodes.get(linkIdx));
            }
        }

        return neighbourNodes;
       
    }
    
    private void lookPathSIandRemoveLink(int agentCurrentPosition) {
        List<Integer> nodes = getNeighbourNodes(agentCurrentPosition);
        for(int nodeCount = 0; nodeCount < nodes.size(); nodeCount++) {
            if(isGateway(nodes.get(nodeCount))) {
                removeLink(agentCurrentPosition, nodes.get(nodeCount));
                return;
            }
        }
        
        // If no gateway in the SI nodes, remove the first one
        removeLink(agentCurrentPosition, nodes.get(0));
        return;
    }
    
}