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
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * Task entity
 * @author Dima Stukalo
 */
@ApiModel(description = "Task entity @author Dima Stukalo")
@Entity
@Table(name = "task")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "task")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "jhi_number", nullable = false)
    private String number;

    @NotNull
    @Column(name = "jhi_date", nullable = false)
    private ZonedDateTime date;

    @Column(name = "full_name")
    private String fullName;

    /**
     * Field is content a string number + | + date + (invoiceNumber + | + invoiceDate)
     */
    @ApiModelProperty(value = "Field is content a string number + | + date + (invoiceNumber + | + invoiceDate)")
    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "invoice_date")
    private ZonedDateTime invoiceDate;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "volume")
    private Double volume;

    @NotNull
    @Column(name = "date_of_execution", nullable = false)
    private ZonedDateTime dateOfExecution;

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

    @OneToMany(mappedBy = "task")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<TaskDetails> taskDetails = new HashSet<>();

    @OneToMany(mappedBy = "task")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<TaskAvailable> taskAvailables = new HashSet<>();

    @ManyToOne
    private Company company;

    @ManyToOne
    private Branch branch;

    @ManyToOne
    private Warehouse warehouse;

    @ManyToOne
    private Transport transport;

    @ManyToOne
    private Point point;

    @ManyToOne
    private Status status;

    // jhipster-needle-entity-add-field - Jhipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public Task number(String number) {
        this.number = number;
        return this;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public Task date(ZonedDateTime date) {
        this.date = date;
        return this;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public String getFullName() {
        return fullName;
    }

    public Task fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public Task invoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        return this;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public ZonedDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public Task invoiceDate(ZonedDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
        return this;
    }

    public void setInvoiceDate(ZonedDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Double getWeight() {
        return weight;
    }

    public Task weight(Double weight) {
        this.weight = weight;
        return this;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getVolume() {
        return volume;
    }

    public Task volume(Double volume) {
        this.volume = volume;
        return this;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public ZonedDateTime getDateOfExecution() {
        return dateOfExecution;
    }

    public Task dateOfExecution(ZonedDateTime dateOfExecution) {
        this.dateOfExecution = dateOfExecution;
        return this;
    }

    public void setDateOfExecution(ZonedDateTime dateOfExecution) {
        this.dateOfExecution = dateOfExecution;
    }

    public String getComment() {
        return comment;
    }

    public Task comment(String comment) {
        this.comment = comment;
        return this;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Task createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public Task createdDate(Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public Task lastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Task lastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Set<TaskDetails> getTaskDetails() {
        return taskDetails;
    }

    public Task taskDetails(Set<TaskDetails> taskDetails) {
        this.taskDetails = taskDetails;
        return this;
    }

    public Task addTaskDetails(TaskDetails taskDetails) {
        this.taskDetails.add(taskDetails);
        taskDetails.setTask(this);
        return this;
    }

    public Task removeTaskDetails(TaskDetails taskDetails) {
        this.taskDetails.remove(taskDetails);
        taskDetails.setTask(null);
        return this;
    }

    public void setTaskDetails(Set<TaskDetails> taskDetails) {
        this.taskDetails = taskDetails;
    }

    public Set<TaskAvailable> getTaskAvailables() {
        return taskAvailables;
    }

    public Task taskAvailables(Set<TaskAvailable> taskAvailables) {
        this.taskAvailables = taskAvailables;
        return this;
    }

    public Task addTaskAvailable(TaskAvailable taskAvailable) {
        this.taskAvailables.add(taskAvailable);
        taskAvailable.setTask(this);
        return this;
    }

    public Task removeTaskAvailable(TaskAvailable taskAvailable) {
        this.taskAvailables.remove(taskAvailable);
        taskAvailable.setTask(null);
        return this;
    }

    public void setTaskAvailables(Set<TaskAvailable> taskAvailables) {
        this.taskAvailables = taskAvailables;
    }

    public Company getCompany() {
        return company;
    }

    public Task company(Company company) {
        this.company = company;
        return this;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Branch getBranch() {
        return branch;
    }

    public Task branch(Branch branch) {
        this.branch = branch;
        return this;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Task warehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
        return this;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Transport getTransport() {
        return transport;
    }

    public Task transport(Transport transport) {
        this.transport = transport;
        return this;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Point getPoint() {
        return point;
    }

    public Task point(Point point) {
        this.point = point;
        return this;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Status getStatus() {
        return status;
    }

    public Task status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
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
        Task task = (Task) o;
        if (task.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), task.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Task{" +
            "id=" + getId() +
            ", number='" + getNumber() + "'" +
            ", date='" + getDate() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", invoiceNumber='" + getInvoiceNumber() + "'" +
            ", invoiceDate='" + getInvoiceDate() + "'" +
            ", weight='" + getWeight() + "'" +
            ", volume='" + getVolume() + "'" +
            ", dateOfExecution='" + getDateOfExecution() + "'" +
            ", comment='" + getComment() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", lastModifiedBy='" + getLastModifiedBy() + "'" +
            ", lastModifiedDate='" + getLastModifiedDate() + "'" +
            "}";
    }
}
