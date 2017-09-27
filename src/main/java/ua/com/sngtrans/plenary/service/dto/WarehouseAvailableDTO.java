package ua.com.sngtrans.plenary.service.dto;


import java.time.Instant;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the WarehouseAvailable entity.
 */
public class WarehouseAvailableDTO implements Serializable {

    private Long id;

    private Boolean active;

    @NotNull
    private ZonedDateTime windowStart;

    @NotNull
    private ZonedDateTime windowEnd;

    private String createdBy;

    private Instant createdDate;

    private String lastModifiedBy;

    private Instant lastModifiedDate;

    private Long warehouseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public ZonedDateTime getWindowStart() {
        return windowStart;
    }

    public void setWindowStart(ZonedDateTime windowStart) {
        this.windowStart = windowStart;
    }

    public ZonedDateTime getWindowEnd() {
        return windowEnd;
    }

    public void setWindowEnd(ZonedDateTime windowEnd) {
        this.windowEnd = windowEnd;
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

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WarehouseAvailableDTO warehouseAvailableDTO = (WarehouseAvailableDTO) o;
        if(warehouseAvailableDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), warehouseAvailableDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "WarehouseAvailableDTO{" +
            "id=" + getId() +
            ", active='" + isActive() + "'" +
            ", windowStart='" + getWindowStart() + "'" +
            ", windowEnd='" + getWindowEnd() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", lastModifiedBy='" + getLastModifiedBy() + "'" +
            ", lastModifiedDate='" + getLastModifiedDate() + "'" +
            "}";
    }
}
