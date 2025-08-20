package home.thienph.xyahoo.data.networks;

public final class Packet {
    private int commandId;
    private int type;
    private ByteBuffer payload;

    public Packet() {
        this.payload = new ByteBuffer();
    }

    public Packet(int commandId, int type) {
        this.commandId = commandId;
        this.type = type;
        this.payload = new ByteBuffer();
    }

    public Packet(int n, int n2, byte[] byArray) {
        this.commandId = n;
        this.type = n2;
        this.payload = new ByteBuffer(byArray);
    }

    public final int getCommandId() {
        return this.commandId;
    }

    public final ByteBuffer getPayload() {
        return this.payload;
    }

    public final void setPayload(ByteBuffer byteBuffer2) {
        this.payload = byteBuffer2;
    }

    public final int getType() {
        return this.type;
    }
}
