import { browser, element, by, $ } from 'protractor';
import { NavBarPage } from './../page-objects/jhi-page-objects';
const path = require('path');

describe('Task e2e test', () => {

    let navBarPage: NavBarPage;
    let taskDialogPage: TaskDialogPage;
    let taskComponentsPage: TaskComponentsPage;
    const fileToUpload = '../../../../main/webapp/content/images/logo-jhipster.png';
    const absolutePath = path.resolve(__dirname, fileToUpload);
    

    beforeAll(() => {
        browser.get('/');
        browser.waitForAngular();
        navBarPage = new NavBarPage();
        navBarPage.getSignInPage().autoSignInUsing('admin', 'admin');
        browser.waitForAngular();
    });

    it('should load Tasks', () => {
        navBarPage.goToEntity('task');
        taskComponentsPage = new TaskComponentsPage();
        expect(taskComponentsPage.getTitle()).toMatch(/plenaryErpApp.task.home.title/);

    });

    it('should load create Task dialog', () => {
        taskComponentsPage.clickOnCreateButton();
        taskDialogPage = new TaskDialogPage();
        expect(taskDialogPage.getModalTitle()).toMatch(/plenaryErpApp.task.home.createOrEditLabel/);
        taskDialogPage.close();
    });

    it('should create and save Tasks', () => {
        taskComponentsPage.clickOnCreateButton();
        taskDialogPage.setNumberInput('number');
        expect(taskDialogPage.getNumberInput()).toMatch('number');
        taskDialogPage.setDateInput(12310020012301);
        expect(taskDialogPage.getDateInput()).toMatch('2001-12-31T02:30');
        taskDialogPage.setFullNameInput('fullName');
        expect(taskDialogPage.getFullNameInput()).toMatch('fullName');
        taskDialogPage.setInvoiceNumberInput('invoiceNumber');
        expect(taskDialogPage.getInvoiceNumberInput()).toMatch('invoiceNumber');
        taskDialogPage.setInvoiceDateInput(12310020012301);
        expect(taskDialogPage.getInvoiceDateInput()).toMatch('2001-12-31T02:30');
        taskDialogPage.setWeightInput('5');
        expect(taskDialogPage.getWeightInput()).toMatch('5');
        taskDialogPage.setVolumeInput('5');
        expect(taskDialogPage.getVolumeInput()).toMatch('5');
        taskDialogPage.setDateOfExecutionInput(12310020012301);
        expect(taskDialogPage.getDateOfExecutionInput()).toMatch('2001-12-31T02:30');
        taskDialogPage.setCommentInput('comment');
        expect(taskDialogPage.getCommentInput()).toMatch('comment');
        taskDialogPage.setCreatedByInput('createdBy');
        expect(taskDialogPage.getCreatedByInput()).toMatch('createdBy');
        taskDialogPage.setCreatedDateInput(12310020012301);
        expect(taskDialogPage.getCreatedDateInput()).toMatch('2001-12-31T02:30');
        taskDialogPage.setLastModifiedByInput('lastModifiedBy');
        expect(taskDialogPage.getLastModifiedByInput()).toMatch('lastModifiedBy');
        taskDialogPage.setLastModifiedDateInput(12310020012301);
        expect(taskDialogPage.getLastModifiedDateInput()).toMatch('2001-12-31T02:30');
        taskDialogPage.companySelectLastOption();
        taskDialogPage.branchSelectLastOption();
        taskDialogPage.warehouseSelectLastOption();
        taskDialogPage.transportSelectLastOption();
        taskDialogPage.pointSelectLastOption();
        taskDialogPage.statusSelectLastOption();
        taskDialogPage.save();
        expect(taskDialogPage.getSaveButton().isPresent()).toBeFalsy();
    }); 

    afterAll(() => {
        navBarPage.autoSignOut();
    });
});

export class TaskComponentsPage {
    createButton = element(by.css('.jh-create-entity'));
    title = element.all(by.css('jhi-task div h2 span')).first();

    clickOnCreateButton() {
        return this.createButton.click();
    }

    getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class TaskDialogPage {
    modalTitle = element(by.css('h4#myTaskLabel'));
    saveButton = element(by.css('.modal-footer .btn.btn-primary'));
    closeButton = element(by.css('button.close'));
    numberInput = element(by.css('input#field_number'));
    dateInput = element(by.css('input#field_date'));
    fullNameInput = element(by.css('input#field_fullName'));
    invoiceNumberInput = element(by.css('input#field_invoiceNumber'));
    invoiceDateInput = element(by.css('input#field_invoiceDate'));
    weightInput = element(by.css('input#field_weight'));
    volumeInput = element(by.css('input#field_volume'));
    dateOfExecutionInput = element(by.css('input#field_dateOfExecution'));
    commentInput = element(by.css('input#field_comment'));
    createdByInput = element(by.css('input#field_createdBy'));
    createdDateInput = element(by.css('input#field_createdDate'));
    lastModifiedByInput = element(by.css('input#field_lastModifiedBy'));
    lastModifiedDateInput = element(by.css('input#field_lastModifiedDate'));
    companySelect = element(by.css('select#field_company'));
    branchSelect = element(by.css('select#field_branch'));
    warehouseSelect = element(by.css('select#field_warehouse'));
    transportSelect = element(by.css('select#field_transport'));
    pointSelect = element(by.css('select#field_point'));
    statusSelect = element(by.css('select#field_status'));

    getModalTitle() {
        return this.modalTitle.getAttribute('jhiTranslate');
    }

    setNumberInput = function (number) {
        this.numberInput.sendKeys(number);
    }

    getNumberInput = function () {
        return this.numberInput.getAttribute('value');
    }

    setDateInput = function (date) {
        this.dateInput.sendKeys(date);
    }

    getDateInput = function () {
        return this.dateInput.getAttribute('value');
    }

    setFullNameInput = function (fullName) {
        this.fullNameInput.sendKeys(fullName);
    }

    getFullNameInput = function () {
        return this.fullNameInput.getAttribute('value');
    }

    setInvoiceNumberInput = function (invoiceNumber) {
        this.invoiceNumberInput.sendKeys(invoiceNumber);
    }

    getInvoiceNumberInput = function () {
        return this.invoiceNumberInput.getAttribute('value');
    }

    setInvoiceDateInput = function (invoiceDate) {
        this.invoiceDateInput.sendKeys(invoiceDate);
    }

    getInvoiceDateInput = function () {
        return this.invoiceDateInput.getAttribute('value');
    }

    setWeightInput = function (weight) {
        this.weightInput.sendKeys(weight);
    }

    getWeightInput = function () {
        return this.weightInput.getAttribute('value');
    }

    setVolumeInput = function (volume) {
        this.volumeInput.sendKeys(volume);
    }

    getVolumeInput = function () {
        return this.volumeInput.getAttribute('value');
    }

    setDateOfExecutionInput = function (dateOfExecution) {
        this.dateOfExecutionInput.sendKeys(dateOfExecution);
    }

    getDateOfExecutionInput = function () {
        return this.dateOfExecutionInput.getAttribute('value');
    }

    setCommentInput = function (comment) {
        this.commentInput.sendKeys(comment);
    }

    getCommentInput = function () {
        return this.commentInput.getAttribute('value');
    }

    setCreatedByInput = function (createdBy) {
        this.createdByInput.sendKeys(createdBy);
    }

    getCreatedByInput = function () {
        return this.createdByInput.getAttribute('value');
    }

    setCreatedDateInput = function (createdDate) {
        this.createdDateInput.sendKeys(createdDate);
    }

    getCreatedDateInput = function () {
        return this.createdDateInput.getAttribute('value');
    }

    setLastModifiedByInput = function (lastModifiedBy) {
        this.lastModifiedByInput.sendKeys(lastModifiedBy);
    }

    getLastModifiedByInput = function () {
        return this.lastModifiedByInput.getAttribute('value');
    }

    setLastModifiedDateInput = function (lastModifiedDate) {
        this.lastModifiedDateInput.sendKeys(lastModifiedDate);
    }

    getLastModifiedDateInput = function () {
        return this.lastModifiedDateInput.getAttribute('value');
    }

    companySelectLastOption = function () {
        this.companySelect.all(by.tagName('option')).last().click();
    }

    companySelectOption = function (option) {
        this.companySelect.sendKeys(option);
    }

    getCompanySelect = function () {
        return this.companySelect;
    }

    getCompanySelectedOption = function () {
        return this.companySelect.element(by.css('option:checked')).getText();
    }

    branchSelectLastOption = function () {
        this.branchSelect.all(by.tagName('option')).last().click();
    }

    branchSelectOption = function (option) {
        this.branchSelect.sendKeys(option);
    }

    getBranchSelect = function () {
        return this.branchSelect;
    }

    getBranchSelectedOption = function () {
        return this.branchSelect.element(by.css('option:checked')).getText();
    }

    warehouseSelectLastOption = function () {
        this.warehouseSelect.all(by.tagName('option')).last().click();
    }

    warehouseSelectOption = function (option) {
        this.warehouseSelect.sendKeys(option);
    }

    getWarehouseSelect = function () {
        return this.warehouseSelect;
    }

    getWarehouseSelectedOption = function () {
        return this.warehouseSelect.element(by.css('option:checked')).getText();
    }

    transportSelectLastOption = function () {
        this.transportSelect.all(by.tagName('option')).last().click();
    }

    transportSelectOption = function (option) {
        this.transportSelect.sendKeys(option);
    }

    getTransportSelect = function () {
        return this.transportSelect;
    }

    getTransportSelectedOption = function () {
        return this.transportSelect.element(by.css('option:checked')).getText();
    }

    pointSelectLastOption = function () {
        this.pointSelect.all(by.tagName('option')).last().click();
    }

    pointSelectOption = function (option) {
        this.pointSelect.sendKeys(option);
    }

    getPointSelect = function () {
        return this.pointSelect;
    }

    getPointSelectedOption = function () {
        return this.pointSelect.element(by.css('option:checked')).getText();
    }

    statusSelectLastOption = function () {
        this.statusSelect.all(by.tagName('option')).last().click();
    }

    statusSelectOption = function (option) {
        this.statusSelect.sendKeys(option);
    }

    getStatusSelect = function () {
        return this.statusSelect;
    }

    getStatusSelectedOption = function () {
        return this.statusSelect.element(by.css('option:checked')).getText();
    }

    save() {
        this.saveButton.click();
    }

    close() {
        this.closeButton.click();
    }

    getSaveButton() {
        return this.saveButton;
    }
}
