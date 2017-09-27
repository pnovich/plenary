import { browser, element, by, $ } from 'protractor';
import { NavBarPage } from './../page-objects/jhi-page-objects';
const path = require('path');

describe('Warehouse e2e test', () => {

    let navBarPage: NavBarPage;
    let warehouseDialogPage: WarehouseDialogPage;
    let warehouseComponentsPage: WarehouseComponentsPage;
    const fileToUpload = '../../../../main/webapp/content/images/logo-jhipster.png';
    const absolutePath = path.resolve(__dirname, fileToUpload);
    

    beforeAll(() => {
        browser.get('/');
        browser.waitForAngular();
        navBarPage = new NavBarPage();
        navBarPage.getSignInPage().autoSignInUsing('admin', 'admin');
        browser.waitForAngular();
    });

    it('should load Warehouses', () => {
        navBarPage.goToEntity('warehouse');
        warehouseComponentsPage = new WarehouseComponentsPage();
        expect(warehouseComponentsPage.getTitle()).toMatch(/plenaryErpApp.warehouse.home.title/);

    });

    it('should load create Warehouse dialog', () => {
        warehouseComponentsPage.clickOnCreateButton();
        warehouseDialogPage = new WarehouseDialogPage();
        expect(warehouseDialogPage.getModalTitle()).toMatch(/plenaryErpApp.warehouse.home.createOrEditLabel/);
        warehouseDialogPage.close();
    });

    it('should create and save Warehouses', () => {
        warehouseComponentsPage.clickOnCreateButton();
        warehouseDialogPage.setNameInput('name');
        expect(warehouseDialogPage.getNameInput()).toMatch('name');
        warehouseDialogPage.setFullNameInput('fullName');
        expect(warehouseDialogPage.getFullNameInput()).toMatch('fullName');
        warehouseDialogPage.setGuidInput('guid');
        expect(warehouseDialogPage.getGuidInput()).toMatch('guid');
        warehouseDialogPage.setLongitudeInput('5');
        expect(warehouseDialogPage.getLongitudeInput()).toMatch('5');
        warehouseDialogPage.setLatitudeInput('5');
        expect(warehouseDialogPage.getLatitudeInput()).toMatch('5');
        warehouseDialogPage.setAddressInput('address');
        expect(warehouseDialogPage.getAddressInput()).toMatch('address');
        warehouseDialogPage.setHouseNumberInput('houseNumber');
        expect(warehouseDialogPage.getHouseNumberInput()).toMatch('houseNumber');
        warehouseDialogPage.setCreatedByInput('createdBy');
        expect(warehouseDialogPage.getCreatedByInput()).toMatch('createdBy');
        warehouseDialogPage.setCreatedDateInput(12310020012301);
        expect(warehouseDialogPage.getCreatedDateInput()).toMatch('2001-12-31T02:30');
        warehouseDialogPage.setLastModifiedByInput('lastModifiedBy');
        expect(warehouseDialogPage.getLastModifiedByInput()).toMatch('lastModifiedBy');
        warehouseDialogPage.setLastModifiedDateInput(12310020012301);
        expect(warehouseDialogPage.getLastModifiedDateInput()).toMatch('2001-12-31T02:30');
        warehouseDialogPage.companySelectLastOption();
        warehouseDialogPage.branchSelectLastOption();
        warehouseDialogPage.countrySelectLastOption();
        warehouseDialogPage.regionSelectLastOption();
        warehouseDialogPage.settlementSelectLastOption();
        warehouseDialogPage.streetSelectLastOption();
        warehouseDialogPage.save();
        expect(warehouseDialogPage.getSaveButton().isPresent()).toBeFalsy();
    }); 

    afterAll(() => {
        navBarPage.autoSignOut();
    });
});

export class WarehouseComponentsPage {
    createButton = element(by.css('.jh-create-entity'));
    title = element.all(by.css('jhi-warehouse div h2 span')).first();

    clickOnCreateButton() {
        return this.createButton.click();
    }

    getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class WarehouseDialogPage {
    modalTitle = element(by.css('h4#myWarehouseLabel'));
    saveButton = element(by.css('.modal-footer .btn.btn-primary'));
    closeButton = element(by.css('button.close'));
    nameInput = element(by.css('input#field_name'));
    fullNameInput = element(by.css('input#field_fullName'));
    guidInput = element(by.css('input#field_guid'));
    longitudeInput = element(by.css('input#field_longitude'));
    latitudeInput = element(by.css('input#field_latitude'));
    addressInput = element(by.css('input#field_address'));
    houseNumberInput = element(by.css('input#field_houseNumber'));
    createdByInput = element(by.css('input#field_createdBy'));
    createdDateInput = element(by.css('input#field_createdDate'));
    lastModifiedByInput = element(by.css('input#field_lastModifiedBy'));
    lastModifiedDateInput = element(by.css('input#field_lastModifiedDate'));
    companySelect = element(by.css('select#field_company'));
    branchSelect = element(by.css('select#field_branch'));
    countrySelect = element(by.css('select#field_country'));
    regionSelect = element(by.css('select#field_region'));
    settlementSelect = element(by.css('select#field_settlement'));
    streetSelect = element(by.css('select#field_street'));

    getModalTitle() {
        return this.modalTitle.getAttribute('jhiTranslate');
    }

    setNameInput = function (name) {
        this.nameInput.sendKeys(name);
    }

    getNameInput = function () {
        return this.nameInput.getAttribute('value');
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

    setLongitudeInput = function (longitude) {
        this.longitudeInput.sendKeys(longitude);
    }

    getLongitudeInput = function () {
        return this.longitudeInput.getAttribute('value');
    }

    setLatitudeInput = function (latitude) {
        this.latitudeInput.sendKeys(latitude);
    }

    getLatitudeInput = function () {
        return this.latitudeInput.getAttribute('value');
    }

    setAddressInput = function (address) {
        this.addressInput.sendKeys(address);
    }

    getAddressInput = function () {
        return this.addressInput.getAttribute('value');
    }

    setHouseNumberInput = function (houseNumber) {
        this.houseNumberInput.sendKeys(houseNumber);
    }

    getHouseNumberInput = function () {
        return this.houseNumberInput.getAttribute('value');
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

    countrySelectLastOption = function () {
        this.countrySelect.all(by.tagName('option')).last().click();
    }

    countrySelectOption = function (option) {
        this.countrySelect.sendKeys(option);
    }

    getCountrySelect = function () {
        return this.countrySelect;
    }

    getCountrySelectedOption = function () {
        return this.countrySelect.element(by.css('option:checked')).getText();
    }

    regionSelectLastOption = function () {
        this.regionSelect.all(by.tagName('option')).last().click();
    }

    regionSelectOption = function (option) {
        this.regionSelect.sendKeys(option);
    }

    getRegionSelect = function () {
        return this.regionSelect;
    }

    getRegionSelectedOption = function () {
        return this.regionSelect.element(by.css('option:checked')).getText();
    }

    settlementSelectLastOption = function () {
        this.settlementSelect.all(by.tagName('option')).last().click();
    }

    settlementSelectOption = function (option) {
        this.settlementSelect.sendKeys(option);
    }

    getSettlementSelect = function () {
        return this.settlementSelect;
    }

    getSettlementSelectedOption = function () {
        return this.settlementSelect.element(by.css('option:checked')).getText();
    }

    streetSelectLastOption = function () {
        this.streetSelect.all(by.tagName('option')).last().click();
    }

    streetSelectOption = function (option) {
        this.streetSelect.sendKeys(option);
    }

    getStreetSelect = function () {
        return this.streetSelect;
    }

    getStreetSelectedOption = function () {
        return this.streetSelect.element(by.css('option:checked')).getText();
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
