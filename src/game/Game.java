package game;

import network.NetworkHandler;

public class Game implements IGameNetwork {

    private NetworkHandler networkHandler;
    private String packetType;
    private int removedCard;
    private int leaveCard;
    private int playerId;

    // if user can play?
    private boolean play = false;

    public Game() {
        this.leaveCard = 0;
    }
    public Game(int leaveCard) {
        this.leaveCard = leaveCard;
    }
    // receive data from network, i need to update state
    @Override
    public void updateStateFromNetwork(String packet) {

        // i receive packet
    	String [] packetInfos = packet.split(",");
    	
    	this.packetType = packetInfos[0];
    	
    	if(packetType == "PLAY") {
        	this.removedCard = Integer.parseInt(packetInfos[1]);
            this.leaveCard = Integer.parseInt(packetInfos[2]);
            this.playerId = Integer.parseInt(packetInfos[3]);
    	}

    }

    // send data to network
    @Override
    public void updateStateOnNetwork() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.leaveCard);

        

        // send data to network
        networkHandler.sendStateInfo(stringBuilder.toString());
    }

    public void play()
    {
        leaveCard--;
    }



    public static void main(String[] args)
    {



    }
}

