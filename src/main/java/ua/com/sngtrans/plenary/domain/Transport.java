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
 * Transport entity
 * @author Dima Stukalo
 */
@ApiModel(description = "Transport entity @author Dima Stukalo")
@Entity
@Table(name = "transport")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "transport")
public class Transport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "ident_number", nullable = false)
    private String identNumber;

    @Column(name = "full_name")
    private String fullName;

    /**
     * Field is content a string id + | + name
     */
    @ApiModelProperty(value = "Field is content a string id + | + name")
    @Column(name = "guid")
    private String guid;

    @Column(name = "jhi_comment")
    private String comment;

    @Column(name = "cost_kilometer")
    private Double costKilometer;

    @Column(name = "cost_houre")
    private Double costHoure;

    @Column(name = "cost_put_in")
    private Double costPutIn;

    @Column(name = "min_weight")
    private Double minWeight;

    @Column(name = "max_weight")
    private Double maxWeight;

    @Column(name = "min_volume")
    private Double minVolume;

    @Column(name = "max_volume")
    private Double maxVolume;

    @NotNull
    @Column(name = "capacity", nullable = false)
    private Double capacity;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "last_modified_date")
    private Instant lastModifiedDate;

    @OneToMany(mappedBy = "transport")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Task> tasks = new HashSet<>();

    @ManyToOne
    private Company company;

    @ManyToOne
    private Branch branch;

    @ManyToOne
    private Warehouse warehouse;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Sensor sensor;

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

    public Transport name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentNumber() {
        return identNumber;
    }

    public Transport identNumber(String identNumber) {
        this.identNumber = identNumber;
        return this;
    }

    public void setIdentNumber(String identNumber) {
        this.identNumber = identNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public Transport fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGuid() {
        return guid;
    }

    public Transport guid(String guid) {
        this.guid = guid;
        return this;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getComment() {
        return comment;
    }

    public Transport comment(String comment) {
        this.comment = comment;
        return this;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getCostKilometer() {
        return costKilometer;
    }

    public Transport costKilometer(Double costKilometer) {
        this.costKilometer = costKilometer;
        return this;
    }

    public void setCostKilometer(Double costKilometer) {
        this.costKilometer = costKilometer;
    }

    public Double getCostHoure() {
        return costHoure;
    }

    public Transport costHoure(Double costHoure) {
        this.costHoure = costHoure;
        return this;
    }

    public void setCostHoure(Double costHoure) {
        this.costHoure = costHoure;
    }

    public Double getCostPutIn() {
        return costPutIn;
    }

    public Transport costPutIn(Double costPutIn) {
        this.costPutIn = costPutIn;
        return this;
    }

    public void setCostPutIn(Double costPutIn) {
        this.costPutIn = costPutIn;
    }

    public Double getMinWeight() {
        return minWeight;
    }

    public Transport minWeight(Double minWeight) {
        this.minWeight = minWeight;
        return this;
    }

    public void setMinWeight(Double minWeight) {
        this.minWeight = minWeight;
    }

    public Double getMaxWeight() {
        return maxWeight;
    }

    public Transport maxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
        return this;
    }

    public void setMaxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Double getMinVolume() {
        return minVolume;
    }

    public Transport minVolume(Double minVolume) {
        this.minVolume = minVolume;
        return this;
    }

    public void setMinVolume(Double minVolume) {
        this.minVolume = minVolume;
    }

    public Double getMaxVolume() {
        return maxVolume;
    }

    public Transport maxVolume(Double maxVolume) {
        this.maxVolume = maxVolume;
        return this;
    }

    public void setMaxVolume(Double maxVolume) {
        this.maxVolume = maxVolume;
    }

    public Double getCapacity() {
        return capacity;
    }

    public Transport capacity(Double capacity) {
        this.capacity = capacity;
        return this;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Transport createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public Transport createdDate(Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public Transport lastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Transport lastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public Transport tasks(Set<Task> tasks) {
        this.tasks = tasks;
        return this;
    }

    public Transport addTask(Task task) {
        this.tasks.add(task);
        task.setTransport(this);
        return this;
    }

    public Transport removeTask(Task task) {
        this.tasks.remove(task);
        task.setTransport(null);
        return this;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Company getCompany() {
        return company;
    }

    public Transport company(Company company) {
        this.company = company;
        return this;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Branch getBranch() {
        return branch;
    }

    public Transport branch(Branch branch) {
        this.branch = branch;
        return this;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Transport warehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
        return this;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Driver getDriver() {
        return driver;
    }

    public Transport driver(Driver driver) {
        this.driver = driver;
        return this;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public Transport sensor(Sensor sensor) {
        this.sensor = sensor;
        return this;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
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
        Transport transport = (Transport) o;
        if (transport.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), transport.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Transport{" +
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
