package testSocket;

public class conditioner {

    private int type;           //����������
    private int room;           //����
    private int _switch;        //����
    private float temperature;  //�¶�
    private int wind;           //����

    public conditioner(float temperature, int wind, int room, int _switch) {
        this.temperature = temperature;
        this.wind = wind;
        this.room = room;
        this._switch = _switch;
    }
    //�޲ι���
    conditioner() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int get_switch() {
        return _switch;
    }

    public void set_switch(int _switch) {
        this._switch = _switch;
    }
}
