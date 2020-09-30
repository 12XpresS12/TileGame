package sk.xpress.tilegame.core.packet;

public abstract class Packet {

    public PacketType packetType;

    public Packet(PacketType packetType) {
        this.packetType = packetType;

    }

}
