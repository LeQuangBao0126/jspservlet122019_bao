package repository;

public interface IRentAreaRepository {
	void insert(String rentArea,Long buildingId );
	void deleteByBuildingId(Long buildingId);
}
