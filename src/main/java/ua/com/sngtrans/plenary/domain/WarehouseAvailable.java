package ua.com.sngtrans.plenary.domain;

import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Warehouse windows available entity
 * @author Dima Stukalo
 */
@ApiModel(description = "Warehouse windows available entity @author Dima Stukalo")
@Entity
@Table(name = "warehouse_available")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "warehouseavailable")
public class WarehouseAvailable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "active")
    private Boolean active;

    @NotNull
    @Column(name = "window_start", nullable = false)
    private ZonedDateTime windowStart;

    @NotNull
    @Column(name = "window_end", nullable = false)
    private ZonedDateTime windowEnd;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "last_modified_date")
    private Instant lastModifiedDate;

    @ManyToOne
    private Warehouse warehouse;

    // jhipster-needle-entity-add-field - Jhipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isActive() {
        return active;
    }

    public WarehouseAvailable active(Boolean active) {
        this.active = active;
        return this;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public ZonedDateTime getWindowStart() {
        return windowStart;
    }

    public WarehouseAvailable windowStart(ZonedDateTime windowStart) {
        this.windowStart = windowStart;
        return this;
    }

    public void setWindowStart(ZonedDateTime windowStart) {
        this.windowStart = windowStart;
    }

    public ZonedDateTime getWindowEnd() {
        return windowEnd;
    }

    public WarehouseAvailable windowEnd(ZonedDateTime windowEnd) {
        this.windowEnd = windowEnd;
        return this;
    }

    public void setWindowEnd(ZonedDateTime windowEnd) {
        this.windowEnd = windowEnd;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public WarehouseAvailable createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public WarehouseAvailable createdDate(Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public WarehouseAvailable lastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public WarehouseAvailable lastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public WarehouseAvailable warehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
        return this;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
    // jhipster-needle-entity-add-getters-setters - Jhipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WarehouseAvailable warehouseAvailable = (WarehouseAvailable) o;
        if (warehouseAvailable.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), warehouseAvailable.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "WarehouseAvailable{" +
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
