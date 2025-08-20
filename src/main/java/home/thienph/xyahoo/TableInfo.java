package home.thienph.xyahoo;

public final class TableInfo {
    public String tableId;
    private byte playerCount;
    public byte gameStatus;
    public String tableName;

    public final byte getPlayerCount() {
        return this.playerCount;
    }

    public final void setPlayerCount(byte by) {
        this.playerCount = by;
        String.valueOf(by);
    }
}
