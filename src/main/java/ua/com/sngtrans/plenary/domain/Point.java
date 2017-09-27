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
 * Point entity
 * @author Dima Stukalo
 */
@ApiModel(description = "Point entity @author Dima Stukalo")
@Entity
@Table(name = "point")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "point")
public class Point implements Serializable {

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

    @Column(name = "house_number")
    private String houseNumber;

    @NotNull
    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "service_time")
    private Long serviceTime;

    @Column(name = "jhi_comment")
    private String comment;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "last_modified_date")
    private Instant lastModifiedDate;

    @OneToMany(mappedBy = "point")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<PointsCoordinate> pointsCoordinates = new HashSet<>();

    @OneToMany(mappedBy = "point")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<PointsAvailable> pointsAvailables = new HashSet<>();

    @OneToMany(mappedBy = "point")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<PointsContact> pointsContacts = new HashSet<>();

    @OneToMany(mappedBy = "point")
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

    public Point name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public Point fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGuid() {
        return guid;
    }

    public Point guid(String guid) {
        this.guid = guid;
        return this;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public Point houseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAddress() {
        return address;
    }

    public Point address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Point longitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Point latitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Long getServiceTime() {
        return serviceTime;
    }

    public Point serviceTime(Long serviceTime) {
        this.serviceTime = serviceTime;
        return this;
    }

    public void setServiceTime(Long serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getComment() {
        return comment;
    }

    public Point comment(String comment) {
        this.comment = comment;
        return this;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Point createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public Point createdDate(Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public Point lastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Point lastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Set<PointsCoordinate> getPointsCoordinates() {
        return pointsCoordinates;
    }

    public Point pointsCoordinates(Set<PointsCoordinate> pointsCoordinates) {
        this.pointsCoordinates = pointsCoordinates;
        return this;
    }

    public Point addPointsCoordinate(PointsCoordinate pointsCoordinate) {
        this.pointsCoordinates.add(pointsCoordinate);
        pointsCoordinate.setPoint(this);
        return this;
    }

    public Point removePointsCoordinate(PointsCoordinate pointsCoordinate) {
        this.pointsCoordinates.remove(pointsCoordinate);
        pointsCoordinate.setPoint(null);
        return this;
    }

    public void setPointsCoordinates(Set<PointsCoordinate> pointsCoordinates) {
        this.pointsCoordinates = pointsCoordinates;
    }

    public Set<PointsAvailable> getPointsAvailables() {
        return pointsAvailables;
    }

    public Point pointsAvailables(Set<PointsAvailable> pointsAvailables) {
        this.pointsAvailables = pointsAvailables;
        return this;
    }

    public Point addPointsAvailable(PointsAvailable pointsAvailable) {
        this.pointsAvailables.add(pointsAvailable);
        pointsAvailable.setPoint(this);
        return this;
    }

    public Point removePointsAvailable(PointsAvailable pointsAvailable) {
        this.pointsAvailables.remove(pointsAvailable);
        pointsAvailable.setPoint(null);
        return this;
    }

    public void setPointsAvailables(Set<PointsAvailable> pointsAvailables) {
        this.pointsAvailables = pointsAvailables;
    }

    public Set<PointsContact> getPointsContacts() {
        return pointsContacts;
    }

    public Point pointsContacts(Set<PointsContact> pointsContacts) {
        this.pointsContacts = pointsContacts;
        return this;
    }

    public Point addPointsContact(PointsContact pointsContact) {
        this.pointsContacts.add(pointsContact);
        pointsContact.setPoint(this);
        return this;
    }

    public Point removePointsContact(PointsContact pointsContact) {
        this.pointsContacts.remove(pointsContact);
        pointsContact.setPoint(null);
        return this;
    }

    public void setPointsContacts(Set<PointsContact> pointsContacts) {
        this.pointsContacts = pointsContacts;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public Point tasks(Set<Task> tasks) {
        this.tasks = tasks;
        return this;
    }

    public Point addTask(Task task) {
        this.tasks.add(task);
        task.setPoint(this);
        return this;
    }

    public Point removeTask(Task task) {
        this.tasks.remove(task);
        task.setPoint(null);
        return this;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Company getCompany() {
        return company;
    }

    public Point company(Company company) {
        this.company = company;
        return this;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Branch getBranch() {
        return branch;
    }

    public Point branch(Branch branch) {
        this.branch = branch;
        return this;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Country getCountry() {
        return country;
    }

    public Point country(Country country) {
        this.country = country;
        return this;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Region getRegion() {
        return region;
    }

    public Point region(Region region) {
        this.region = region;
        return this;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Settlement getSettlement() {
        return settlement;
    }

    public Point settlement(Settlement settlement) {
        this.settlement = settlement;
        return this;
    }

    public void setSettlement(Settlement settlement) {
        this.settlement = settlement;
    }

    public Street getStreet() {
        return street;
    }

    public Point street(Street street) {
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
        Point point = (Point) o;
        if (point.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), point.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Point{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", guid='" + getGuid() + "'" +
            ", houseNumber='" + getHouseNumber() + "'" +
            ", address='" + getAddress() + "'" +
            ", longitude='" + getLongitude() + "'" +
            ", latitude='" + getLatitude() + "'" +
            ", serviceTime='" + getServiceTime() + "'" +
            ", comment='" + getComment() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", lastModifiedBy='" + getLastModifiedBy() + "'" +
            ", lastModifiedDate='" + getLastModifiedDate() + "'" +
            "}";
    }
}
