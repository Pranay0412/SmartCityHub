package DataBase;

import Model.ParkingLot;

import java.util.List;

public class ParkingLotDAO {
    public void addParkingLot(ParkingLot lot){}
    public ParkingLot getParkingLotById(int lotId){}
    public List<ParkingLot> getAllParkingLots(){}
    public void updateParkingOccupancy(int lotId, int newOccupancy){}
    public List<ParkingLot> getAvailableParkingLots(){}
}
