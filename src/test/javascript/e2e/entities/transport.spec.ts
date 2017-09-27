import { browser, element, by, $ } from 'protractor';
import { NavBarPage } from './../page-objects/jhi-page-objects';
const path = require('path');

describe('Transport e2e test', () => {

    let navBarPage: NavBarPage;
    let transportDialogPage: TransportDialogPage;
    let transportComponentsPage: TransportComponentsPage;
    const fileToUpload = '../../../../main/webapp/content/images/logo-jhipster.png';
    const absolutePath = path.resolve(__dirname, fileToUpload);
    

    beforeAll(() => {
        browser.get('/');
        browser.waitForAngular();
        navBarPage = new NavBarPage();
        navBarPage.getSignInPage().autoSignInUsing('admin', 'admin');
        browser.waitForAngular();
    });

    it('should load Transports', () => {
        navBarPage.goToEntity('transport');
        transportComponentsPage = new TransportComponentsPage();
        expect(transportComponentsPage.getTitle()).toMatch(/plenaryErpApp.transport.home.title/);

    });

    it('should load create Transport dialog', () => {
        transportComponentsPage.clickOnCreateButton();
        transportDialogPage = new TransportDialogPage();
        expect(transportDialogPage.getModalTitle()).toMatch(/plenaryErpApp.transport.home.createOrEditLabel/);
        transportDialogPage.close();
    });

    it('should create and save Transports', () => {
        transportComponentsPage.clickOnCreateButton();
        transportDialogPage.setNameInput('name');
        expect(transportDialogPage.getNameInput()).toMatch('name');
        transportDialogPage.setIdentNumberInput('identNumber');
        expect(transportDialogPage.getIdentNumberInput()).toMatch('identNumber');
        transportDialogPage.setFullNameInput('fullName');
        expect(transportDialogPage.getFullNameInput()).toMatch('fullName');
        transportDialogPage.setGuidInput('guid');
        expect(transportDialogPage.getGuidInput()).toMatch('guid');
        transportDialogPage.setCommentInput('comment');
        expect(transportDialogPage.getCommentInput()).toMatch('comment');
        transportDialogPage.setCostKilometerInput('5');
        expect(transportDialogPage.getCostKilometerInput()).toMatch('5');
        transportDialogPage.setCostHoureInput('5');
        expect(transportDialogPage.getCostHoureInput()).toMatch('5');
        transportDialogPage.setCostPutInInput('5');
        expect(transportDialogPage.getCostPutInInput()).toMatch('5');
        transportDialogPage.setMinWeightInput('5');
        expect(transportDialogPage.getMinWeightInput()).toMatch('5');
        transportDialogPage.setMaxWeightInput('5');
        expect(transportDialogPage.getMaxWeightInput()).toMatch('5');
        transportDialogPage.setMinVolumeInput('5');
        expect(transportDialogPage.getMinVolumeInput()).toMatch('5');
        transportDialogPage.setMaxVolumeInput('5');
        expect(transportDialogPage.getMaxVolumeInput()).toMatch('5');
        transportDialogPage.setCapacityInput('5');
        expect(transportDialogPage.getCapacityInput()).toMatch('5');
        transportDialogPage.setCreatedByInput('createdBy');
        expect(transportDialogPage.getCreatedByInput()).toMatch('createdBy');
        transportDialogPage.setCreatedDateInput(12310020012301);
        expect(transportDialogPage.getCreatedDateInput()).toMatch('2001-12-31T02:30');
        transportDialogPage.setLastModifiedByInput('lastModifiedBy');
        expect(transportDialogPage.getLastModifiedByInput()).toMatch('lastModifiedBy');
        transportDialogPage.setLastModifiedDateInput(12310020012301);
        expect(transportDialogPage.getLastModifiedDateInput()).toMatch('2001-12-31T02:30');
        transportDialogPage.companySelectLastOption();
        transportDialogPage.branchSelectLastOption();
        transportDialogPage.warehouseSelectLastOption();
        transportDialogPage.driverSelectLastOption();
        transportDialogPage.sensorSelectLastOption();
        transportDialogPage.save();
        expect(transportDialogPage.getSaveButton().isPresent()).toBeFalsy();
    }); 

    afterAll(() => {
        navBarPage.autoSignOut();
    });
});

export class TransportComponentsPage {
    createButton = element(by.css('.jh-create-entity'));
    title = element.all(by.css('jhi-transport div h2 span')).first();

    clickOnCreateButton() {
        return this.createButton.click();
    }

    getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class TransportDialogPage {
    modalTitle = element(by.css('h4#myTransportLabel'));
    saveButton = element(by.css('.modal-footer .btn.btn-primary'));
    closeButton = element(by.css('button.close'));
    nameInput = element(by.css('input#field_name'));
    identNumberInput = element(by.css('input#field_identNumber'));
    fullNameInput = element(by.css('input#field_fullName'));
    guidInput = element(by.css('input#field_guid'));
    commentInput = element(by.css('input#field_comment'));
    costKilometerInput = element(by.css('input#field_costKilometer'));
    costHoureInput = element(by.css('input#field_costHoure'));
    costPutInInput = element(by.css('input#field_costPutIn'));
    minWeightInput = element(by.css('input#field_minWeight'));
    maxWeightInput = element(by.css('input#field_maxWeight'));
    minVolumeInput = element(by.css('input#field_minVolume'));
    maxVolumeInput = element(by.css('input#field_maxVolume'));
    capacityInput = element(by.css('input#field_capacity'));
    createdByInput = element(by.css('input#field_createdBy'));
    createdDateInput = element(by.css('input#field_createdDate'));
    lastModifiedByInput = element(by.css('input#field_lastModifiedBy'));
    lastModifiedDateInput = element(by.css('input#field_lastModifiedDate'));
    companySelect = element(by.css('select#field_company'));
    branchSelect = element(by.css('select#field_branch'));
    warehouseSelect = element(by.css('select#field_warehouse'));
    driverSelect = element(by.css('select#field_driver'));
    sensorSelect = element(by.css('select#field_sensor'));

    getModalTitle() {
        return this.modalTitle.getAttribute('jhiTranslate');
    }

    setNameInput = function (name) {
        this.nameInput.sendKeys(name);
    }

    getNameInput = function () {
        return this.nameInput.getAttribute('value');
    }

    setIdentNumberInput = function (identNumber) {
        this.identNumberInput.sendKeys(identNumber);
    }

    getIdentNumberInput = function () {
        return this.identNumberInput.getAttribute('value');
    }

    setFullNameInput = function (fullName) {
        this.fullNameInput.sendKeys(fullName);
    }

    getFullNameInput = function () {
        return this.fullNameInput.getAttribute('value');
    }

    setGuidInput = function (guid) {
        this.guidInput.sendKeys(guid);
    }

    getGuidInput = function () {
        return this.guidInput.getAttribute('value');
    }

    setCommentInput = function (comment) {
        this.commentInput.sendKeys(comment);
    }

    getCommentInput = function () {
        return this.commentInput.getAttribute('value');
    }

    setCostKilometerInput = function (costKilometer) {
        this.costKilometerInput.sendKeys(costKilometer);
    }

    getCostKilometerInput = function () {
        return this.costKilometerInput.getAttribute('value');
    }

    setCostHoureInput = function (costHoure) {
        this.costHoureInput.sendKeys(costHoure);
    }

    getCostHoureInput = function () {
        return this.costHoureInput.getAttribute('value');
    }

    setCostPutInInput = function (costPutIn) {
        this.costPutInInput.sendKeys(costPutIn);
    }

    getCostPutInInput = function () {
        return this.costPutInInput.getAttribute('value');
    }

    setMinWeightInput = function (minWeight) {
        this.minWeightInput.sendKeys(minWeight);
    }

    getMinWeightInput = function () {
        return this.minWeightInput.getAttribute('value');
    }

    setMaxWeightInput = function (maxWeight) {
        this.maxWeightInput.sendKeys(maxWeight);
    }

    getMaxWeightInput = function () {
        return this.maxWeightInput.getAttribute('value');
    }

    setMinVolumeInput = function (minVolume) {
        this.minVolumeInput.sendKeys(minVolume);
    }

    getMinVolumeInput = function () {
        return this.minVolumeInput.getAttribute('value');
    }

    setMaxVolumeInput = function (maxVolume) {
        this.maxVolumeInput.sendKeys(maxVolume);
    }

    getMaxVolumeInput = function () {
        return this.maxVolumeInput.getAttribute('value');
    }

    setCapacityInput = function (capacity) {
        this.capacityInput.sendKeys(capacity);
    }

    getCapacityInput = function () {
        return this.capacityInput.getAttribute('value');
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

    driverSelectLastOption = function () {
        this.driverSelect.all(by.tagName('option')).last().click();
    }

    driverSelectOption = function (option) {
        this.driverSelect.sendKeys(option);
    }

    getDriverSelect = function () {
        return this.driverSelect;
    }

    getDriverSelectedOption = function () {
        return this.driverSelect.element(by.css('option:checked')).getText();
    }

    sensorSelectLastOption = function () {
        this.sensorSelect.all(by.tagName('option')).last().click();
    }

    sensorSelectOption = function (option) {
        this.sensorSelect.sendKeys(option);
    }

    getSensorSelect = function () {
        return this.sensorSelect;
    }

    getSensorSelectedOption = function () {
        return this.sensorSelect.element(by.css('option:checked')).getText();
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
