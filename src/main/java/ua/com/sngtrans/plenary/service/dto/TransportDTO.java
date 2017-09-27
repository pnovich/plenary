package ua.com.sngtrans.plenary.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the Transport entity.
 */
public class TransportDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String identNumber;

    private String fullName;

    private String guid;

    private String comment;

    private Double costKilometer;

    private Double costHoure;

    private Double costPutIn;

    private Double minWeight;

    private Double maxWeight;

    private Double minVolume;

    private Double maxVolume;

    @NotNull
    private Double capacity;

    private String createdBy;

    private Instant createdDate;

    private String lastModifiedBy;

    private Instant lastModifiedDate;

    private Long companyId;

    private String companyFullName;

    private Long branchId;

    private String branchFullName;

    private Long warehouseId;

    private String warehouseFullName;

    private Long driverId;

    private String driverFullName;

    private Long sensorId;

    private String sensorFullName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentNumber() {
        return identNumber;
    }

    public void setIdentNumber(String identNumber) {
        this.identNumber = identNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getCostKilometer() {
        return costKilometer;
    }

    public void setCostKilometer(Double costKilometer) {
        this.costKilometer = costKilometer;
    }

    public Double getCostHoure() {
        return costHoure;
    }

    public void setCostHoure(Double costHoure) {
        this.costHoure = costHoure;
    }

    public Double getCostPutIn() {
        return costPutIn;
    }

    public void setCostPutIn(Double costPutIn) {
        this.costPutIn = costPutIn;
    }

    public Double getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(Double minWeight) {
        this.minWeight = minWeight;
    }

    public Double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Double getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(Double minVolume) {
        this.minVolume = minVolume;
    }

    public Double getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(Double maxVolume) {
        this.maxVolume = maxVolume;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyFullName() {
        return companyFullName;
    }

    public void setCompanyFullName(String companyFullName) {
        this.companyFullName = companyFullName;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getBranchFullName() {
        return branchFullName;
    }

    public void setBranchFullName(String branchFullName) {
        this.branchFullName = branchFullName;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseFullName() {
        return warehouseFullName;
    }

    public void setWarehouseFullName(String warehouseFullName) {
        this.warehouseFullName = warehouseFullName;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getDriverFullName() {
        return driverFullName;
    }

    public void setDriverFullName(String driverFullName) {
        this.driverFullName = driverFullName;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorFullName() {
        return sensorFullName;
    }

    public void setSensorFullName(String sensorFullName) {
        this.sensorFullName = sensorFullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TransportDTO transportDTO = (TransportDTO) o;
        if(transportDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), transportDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TransportDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", identNumber='" + getIdentNumber() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", guid='" + getGuid() + "'" +
            ", comment='" + getComment() + "'" +
            ", costKilometer='" + getCostKilometer() + "'" +
            ", costHoure='" + getCostHoure() + "'" +
            ", costPutIn='" + getCostPutIn() + "'" +
            ", minWeight='" + getMinWeight() + "'" +
            ", maxWeight='" + getMaxWeight() + "'" +
            ", minVolume='" + getMinVolume() + "'" +
            ", maxVolume='" + getMaxVolume() + "'" +
            ", capacity='" + getCapacity() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", lastModifiedBy='" + getLastModifiedBy() + "'" +
            ", lastModifiedDate='" + getLastModifiedDate() + "'" +
            "}";
    }
}
