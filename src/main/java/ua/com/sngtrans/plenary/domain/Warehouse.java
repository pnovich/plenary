package ua.com.sngtrans.plenary.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * Warehouse entity
 * @author Dima Stukalo
 */
@ApiModel(description = "Warehouse entity @author Dima Stukalo")
@Entity
@Table(name = "warehouse")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "warehouse")
public class Warehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "full_name")
    private String fullName;

    /**
     * Field is content a string id + | + name
     */
    @ApiModelProperty(value = "Field is content a string id + | + name")
    @Column(name = "guid")
    private String guid;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @NotNull
    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "last_modified_date")
    private Instant lastModifiedDate;

    @OneToMany(mappedBy = "warehouse")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<WarehouseAvailable> warehouseAvailables = new HashSet<>();

    @OneToMany(mappedBy = "warehouse")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Transport> transports = new HashSet<>();

    @OneToMany(mappedBy = "warehouse")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Task> tasks = new HashSet<>();

    @ManyToOne
    private Company company;

    @ManyToOne
    private Branch branch;

    @ManyToOne
    private Country country;

    @ManyToOne
    private Region region;

    @ManyToOne
    private Settlement settlement;

    @ManyToOne
    private Street street;

    // jhipster-needle-entity-add-field - Jhipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Warehouse name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public Warehouse fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGuid() {
        return guid;
    }

    public Warehouse guid(String guid) {
        this.guid = guid;
        return this;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Warehouse longitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Warehouse latitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public Warehouse address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public Warehouse houseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Warehouse createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public Warehouse createdDate(Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public Warehouse lastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Warehouse lastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Set<WarehouseAvailable> getWarehouseAvailables() {
        return warehouseAvailables;
    }

    public Warehouse warehouseAvailables(Set<WarehouseAvailable> warehouseAvailables) {
        this.warehouseAvailables = warehouseAvailables;
        return this;
    }

    public Warehouse addWarehouseAvailable(WarehouseAvailable warehouseAvailable) {
        this.warehouseAvailables.add(warehouseAvailable);
        warehouseAvailable.setWarehouse(this);
        return this;
    }

    public Warehouse removeWarehouseAvailable(WarehouseAvailable warehouseAvailable) {
        this.warehouseAvailables.remove(warehouseAvailable);
        warehouseAvailable.setWarehouse(null);
        return this;
    }

    public void setWarehouseAvailables(Set<WarehouseAvailable> warehouseAvailables) {
        this.warehouseAvailables = warehouseAvailables;
    }

    public Set<Transport> getTransports() {
        return transports;
    }

    public Warehouse transports(Set<Transport> transports) {
        this.transports = transports;
        return this;
    }

    public Warehouse addTransport(Transport transport) {
        this.transports.add(transport);
        transport.setWarehouse(this);
        return this;
    }

    public Warehouse removeTransport(Transport transport) {
        this.transports.remove(transport);
        transport.setWarehouse(null);
        return this;
    }

    public void setTransports(Set<Transport> transports) {
        this.transports = transports;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public Warehouse tasks(Set<Task> tasks) {
        this.tasks = tasks;
        return this;
    }

    public Warehouse addTask(Task task) {
        this.tasks.add(task);
        task.setWarehouse(this);
        return this;
    }

    public Warehouse removeTask(Task task) {
        this.tasks.remove(task);
        task.setWarehouse(null);
        return this;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Company getCompany() {
        return company;
    }

    public Warehouse company(Company company) {
        this.company = company;
        return this;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Branch getBranch() {
        return branch;
    }

    public Warehouse branch(Branch branch) {
        this.branch = branch;
        return this;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Country getCountry() {
        return country;
    }

    public Warehouse country(Country country) {
        this.country = country;
        return this;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Region getRegion() {
        return region;
    }

    public Warehouse region(Region region) {
        this.region = region;
        return this;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Settlement getSettlement() {
        return settlement;
    }

    public Warehouse settlement(Settlement settlement) {
        this.settlement = settlement;
        return this;
    }

    public void setSettlement(Settlement settlement) {
        this.settlement = settlement;
    }

    public Street getStreet() {
        return street;
    }

    public Warehouse street(Street street) {
        this.street = street;
        return this;
    }

    public void setStreet(Street street) {
        this.street = street;
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
        Warehouse warehouse = (Warehouse) o;
        if (warehouse.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), warehouse.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Warehouse{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", guid='" + getGuid() + "'" +
            ", longitude='" + getLongitude() + "'" +
            ", latitude='" + getLatitude() + "'" +
            ", address='" + getAddress() + "'" +
            ", houseNumber='" + getHouseNumber() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", lastModifiedBy='" + getLastModifiedBy() + "'" +
            ", lastModifiedDate='" + getLastModifiedDate() + "'" +
            "}";
    }
}
