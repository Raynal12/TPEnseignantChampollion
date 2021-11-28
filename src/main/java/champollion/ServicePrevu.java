package champollion;

public class ServicePrevu {
	// TODO : implémenter cette classe
    public UE ue;
    public int volumeCM;
    public int volumeTD;
    public int volumeTP;

    public ServicePrevu(int volumeCM, int volumeTD, int volumeTP) {
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
    }

    public UE getUe() {
        return ue;
    }

    public int getVolumeCM() {
        return volumeCM;
    }

    public int getVolumeTD() {
        return volumeTD;
    }

    public int getVolumeTP() {
        return volumeTP;
    }
    
    
    public int ajouterCM(int heure) {
        this.volumeCM = this.volumeCM + heure;
        return volumeCM;
    }
    public int ajouterTD(int heure) {
        this.volumeTD = this.volumeTD + heure;
        return volumeTD;
    }
    public int ajouterTP(int heure) {
        this.volumeTP = this.volumeTP + heure;
        return volumeTP;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }

    public void setVolumeCM(int volumeCM) {
        this.volumeCM = volumeCM;
    }

    public void setVolumeTD(int volumeTD) {
        this.volumeTD = volumeTD;
    }

    public void setVolumeTP(int volumeTP) {
        this.volumeTP = volumeTP;
    }
}
