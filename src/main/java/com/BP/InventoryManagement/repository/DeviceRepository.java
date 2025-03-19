package com.BP.InventoryManagement.repository;
import com.BP.InventoryManagement.model.Device;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface DeviceRepository extends Neo4jRepository<Device, Long> {
    public Optional<Device> findByName(String name);

    @Query("MATCH (d:Device) WHERE d.deviceType=$deviceType RETURN d")
    public Optional<Device> findByDeviceType(String deviceType);

    @Query("""
            CALL{
                MATCH (device:Device)
                RETURN COUNT(device) AS totalDevices
            }
            
            CALL{
                MATCH (shelfPosition:ShelfPosition)
                RETURN COUNT(shelfPosition) AS totalShelfPositions
            }
            
            CALL{
                MATCH (shelf:Shelf)
                RETURN COUNT(shelf) AS totalShelves
            }
            
            RETURN {
                totalDevices: totalDevices,
                totalShelfPositions: totalShelfPositions,
                totalShelves: totalShelves
            }
            """)
    public List<Map<String,Object>> totalInventoryItems();

}
