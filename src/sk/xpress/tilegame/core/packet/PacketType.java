package sk.xpress.tilegame.core.packet;

import sk.xpress.tilegame.core.packet.client.PlaySound;
import sk.xpress.tilegame.core.packet.server.BreakBlock;

public class PacketType {

    enum Server implements IPacketType {

        BreakBlock(new BreakBlock());

        private sk.xpress.tilegame.core.packet.IPacketType packetType;

        Server(sk.xpress.tilegame.core.packet.IPacketType packetType) {
            this.packetType = packetType;

        }

        @Override
        public sk.xpress.tilegame.core.packet.IPacketType getPacketType() {
            return null;
        }
    }

    enum Client implements IPacketType {
        PlaySound(new PlaySound());

        private sk.xpress.tilegame.core.packet.IPacketType packetType;

        Client(sk.xpress.tilegame.core.packet.IPacketType packetType) {
            this.packetType = packetType;
        }

        @Override
        public sk.xpress.tilegame.core.packet.IPacketType getPacketType() {
            return null;
        }
    }

    private interface IPacketType {
        sk.xpress.tilegame.core.packet.IPacketType getPacketType();
    }
}
