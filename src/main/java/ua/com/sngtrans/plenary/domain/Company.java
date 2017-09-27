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
 * Company entity
 * @author Dima Stukalo
 */
@ApiModel(description = "Company entity @author Dima Stukalo")
@Entity
@Table(name = "company")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "company")
public class Company implements Serializable {

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
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "last_modified_date")
    private Instant lastModifiedDate;

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Branch> branches = new HashSet<>();

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Warehouse> warehouses = new HashSet<>();

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Point> points = new HashSet<>();

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Driver> drivers = new HashSet<>();

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Sensor> sensors = new HashSet<>();

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Transport> transports = new HashSet<>();

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Task> tasks = new HashSet<>();

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

    public Company name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public Company fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public Company email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public Company phone(String phone) {
        this.phone = phone;
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public Company address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Company createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public Company createdDate(Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public Company lastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Company lastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Set<Branch> getBranches() {
        return branches;
    }

    public Company branches(Set<Branch> branches) {
        this.branches = branches;
        return this;
    }

    public Company addBranch(Branch branch) {
        this.branches.add(branch);
        branch.setCompany(this);
        return this;
    }

    public Company removeBranch(Branch branch) {
        this.branches.remove(branch);
        branch.setCompany(null);
        return this;
    }

    public void setBranches(Set<Branch> branches) {
        this.branches = branches;
    }

    public Set<Warehouse> getWarehouses() {
        return warehouses;
    }

    public Company warehouses(Set<Warehouse> warehouses) {
        this.warehouses = warehouses;
        return this;
    }

    public Company addWarehouse(Warehouse warehouse) {
        this.warehouses.add(warehouse);
        warehouse.setCompany(this);
        return this;
    }

    public Company removeWarehouse(Warehouse warehouse) {
        this.warehouses.remove(warehouse);
        warehouse.setCompany(null);
        return this;
    }

    public void setWarehouses(Set<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public Set<Point> getPoints() {
        return points;
    }

    public Company points(Set<Point> points) {
        this.points = points;
        return this;
    }

    public Company addPoint(Point point) {
        this.points.add(point);
        point.setCompany(this);
        return this;
    }

    public Company removePoint(Point point) {
        this.points.remove(point);
        point.setCompany(null);
        return this;
    }

    public void setPoints(Set<Point> points) {
        this.points = points;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public Company drivers(Set<Driver> drivers) {
        this.drivers = drivers;
        return this;
    }

    public Company addDriver(Driver driver) {
        this.drivers.add(driver);
        driver.setCompany(this);
        return this;
    }

    public Company removeDriver(Driver driver) {
        this.drivers.remove(driver);
        driver.setCompany(null);
        return this;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public Set<Sensor> getSensors() {
        return sensors;
    }

    public Company sensors(Set<Sensor> sensors) {
        this.sensors = sensors;
        return this;
    }

    public Company addSensor(Sensor sensor) {
        this.sensors.add(sensor);
        sensor.setCompany(this);
        return this;
    }

    public Company removeSensor(Sensor sensor) {
        this.sensors.remove(sensor);
        sensor.setCompany(null);
        return this;
    }

    public void setSensors(Set<Sensor> sensors) {
        this.sensors = sensors;
    }

    public Set<Transport> getTransports() {
        return transports;
    }

    public Company transports(Set<Transport> transports) {
        this.transports = transports;
        return this;
    }

    public Company addTransport(Transport transport) {
        this.transports.add(transport);
        transport.setCompany(this);
        return this;
    }

    public Company removeTransport(Transport transport) {
        this.transports.remove(transport);
        transport.setCompany(null);
        return this;
    }

    public void setTransports(Set<Transport> transports) {
        this.transports = transports;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public Company tasks(Set<Task> tasks) {
        this.tasks = tasks;
        return this;
    }

    public Company addTask(Task task) {
        this.tasks.add(task);
        task.setCompany(this);
        return this;
    }

    public Company removeTask(Task task) {
        this.tasks.remove(task);
        task.setCompany(null);
        return this;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
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
        Company company = (Company) o;
        if (company.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), company.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Company{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", email='" + getEmail() + "'" +
            ", phone='" + getPhone() + "'" +
            ", address='" + getAddress() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", lastModifiedBy='" + getLastModifiedBy() + "'" +
            ", lastModifiedDate='" + getLastModifiedDate() + "'" +
            "}";
    }
}
