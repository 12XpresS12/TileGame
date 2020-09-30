package sk.xpress.tilegame.core.packet.server;

import sk.xpress.tilegame.core.packet.IPacketType;

public class BreakBlock implements IPacketType {

    @Override
    public int PacketId() {
        return 0;
    }
}
