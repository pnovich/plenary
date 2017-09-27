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
 * Settlement entity
 * @author Dima Stukalo
 */
@ApiModel(description = "Settlement entity @author Dima Stukalo")
@Entity
@Table(name = "settlement")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "settlement")
public class Settlement implements Serializable {

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

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "last_modified_date")
    private Instant lastModifiedDate;

    @OneToMany(mappedBy = "settlement")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Street> streets = new HashSet<>();

    @OneToMany(mappedBy = "settlement")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Warehouse> warehouses = new HashSet<>();

    @OneToMany(mappedBy = "settlement")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Point> points = new HashSet<>();

    @ManyToOne
    private Region region;

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

    public Settlement name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public Settlement fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGuid() {
        return guid;
    }

    public Settlement guid(String guid) {
        this.guid = guid;
        return this;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Settlement createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public Settlement createdDate(Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public Settlement lastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Settlement lastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Set<Street> getStreets() {
        return streets;
    }

    public Settlement streets(Set<Street> streets) {
        this.streets = streets;
        return this;
    }

    public Settlement addStreet(Street street) {
        this.streets.add(street);
        street.setSettlement(this);
        return this;
    }

    public Settlement removeStreet(Street street) {
        this.streets.remove(street);
        street.setSettlement(null);
        return this;
    }

    public void setStreets(Set<Street> streets) {
        this.streets = streets;
    }

    public Set<Warehouse> getWarehouses() {
        return warehouses;
    }

    public Settlement warehouses(Set<Warehouse> warehouses) {
        this.warehouses = warehouses;
        return this;
    }

    public Settlement addWarehouse(Warehouse warehouse) {
        this.warehouses.add(warehouse);
        warehouse.setSettlement(this);
        return this;
    }

    public Settlement removeWarehouse(Warehouse warehouse) {
        this.warehouses.remove(warehouse);
        warehouse.setSettlement(null);
        return this;
    }

    public void setWarehouses(Set<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public Set<Point> getPoints() {
        return points;
    }

    public Settlement points(Set<Point> points) {
        this.points = points;
        return this;
    }

    public Settlement addPoint(Point point) {
        this.points.add(point);
        point.setSettlement(this);
        return this;
    }

    public Settlement removePoint(Point point) {
        this.points.remove(point);
        point.setSettlement(null);
        return this;
    }

    public void setPoints(Set<Point> points) {
        this.points = points;
    }

    public Region getRegion() {
        return region;
    }

    public Settlement region(Region region) {
        this.region = region;
        return this;
    }

    public void setRegion(Region region) {
        this.region = region;
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
        Settlement settlement = (Settlement) o;
        if (settlement.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), settlement.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Settlement{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", guid='" + getGuid() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", lastModifiedBy='" + getLastModifiedBy() + "'" +
            ", lastModifiedDate='" + getLastModifiedDate() + "'" +
            "}";
    }
}
