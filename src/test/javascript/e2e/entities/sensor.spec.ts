import { browser, element, by, $ } from 'protractor';
import { NavBarPage } from './../page-objects/jhi-page-objects';
const path = require('path');

describe('Sensor e2e test', () => {

    let navBarPage: NavBarPage;
    let sensorDialogPage: SensorDialogPage;
    let sensorComponentsPage: SensorComponentsPage;
    const fileToUpload = '../../../../main/webapp/content/images/logo-jhipster.png';
    const absolutePath = path.resolve(__dirname, fileToUpload);
    

    beforeAll(() => {
        browser.get('/');
        browser.waitForAngular();
        navBarPage = new NavBarPage();
        navBarPage.getSignInPage().autoSignInUsing('admin', 'admin');
        browser.waitForAngular();
    });

    it('should load Sensors', () => {
        navBarPage.goToEntity('sensor');
        sensorComponentsPage = new SensorComponentsPage();
        expect(sensorComponentsPage.getTitle()).toMatch(/plenaryErpApp.sensor.home.title/);

    });

    it('should load create Sensor dialog', () => {
        sensorComponentsPage.clickOnCreateButton();
        sensorDialogPage = new SensorDialogPage();
        expect(sensorDialogPage.getModalTitle()).toMatch(/plenaryErpApp.sensor.home.createOrEditLabel/);
        sensorDialogPage.close();
    });

    it('should create and save Sensors', () => {
        sensorComponentsPage.clickOnCreateButton();
        sensorDialogPage.setNameInput('name');
        expect(sensorDialogPage.getNameInput()).toMatch('name');
        sensorDialogPage.setFullNameInput('fullName');
        expect(sensorDialogPage.getFullNameInput()).toMatch('fullName');
        sensorDialogPage.setImeiInput('imei');
        expect(sensorDialogPage.getImeiInput()).toMatch('imei');
        sensorDialogPage.setGuidInput('guid');
        expect(sensorDialogPage.getGuidInput()).toMatch('guid');
        sensorDialogPage.setCreatedByInput('createdBy');
        expect(sensorDialogPage.getCreatedByInput()).toMatch('createdBy');
        sensorDialogPage.setCreatedDateInput(12310020012301);
        expect(sensorDialogPage.getCreatedDateInput()).toMatch('2001-12-31T02:30');
        sensorDialogPage.setLastModifiedByInput('lastModifiedBy');
        expect(sensorDialogPage.getLastModifiedByInput()).toMatch('lastModifiedBy');
        sensorDialogPage.setLastModifiedDateInput(12310020012301);
        expect(sensorDialogPage.getLastModifiedDateInput()).toMatch('2001-12-31T02:30');
        sensorDialogPage.companySelectLastOption();
        sensorDialogPage.branchSelectLastOption();
        sensorDialogPage.save();
        expect(sensorDialogPage.getSaveButton().isPresent()).toBeFalsy();
    }); 

    afterAll(() => {
        navBarPage.autoSignOut();
    });
});

export class SensorComponentsPage {
    createButton = element(by.css('.jh-create-entity'));
    title = element.all(by.css('jhi-sensor div h2 span')).first();

    clickOnCreateButton() {
        return this.createButton.click();
    }

    getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class SensorDialogPage {
    modalTitle = element(by.css('h4#mySensorLabel'));
    saveButton = element(by.css('.modal-footer .btn.btn-primary'));
    closeButton = element(by.css('button.close'));
    nameInput = element(by.css('input#field_name'));
    fullNameInput = element(by.css('input#field_fullName'));
    imeiInput = element(by.css('input#field_imei'));
    guidInput = element(by.css('input#field_guid'));
    createdByInput = element(by.css('input#field_createdBy'));
    createdDateInput = element(by.css('input#field_createdDate'));
    lastModifiedByInput = element(by.css('input#field_lastModifiedBy'));
    lastModifiedDateInput = element(by.css('input#field_lastModifiedDate'));
    companySelect = element(by.css('select#field_company'));
    branchSelect = element(by.css('select#field_branch'));

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

    setImeiInput = function (imei) {
        this.imeiInput.sendKeys(imei);
    }

    getImeiInput = function () {
        return this.imeiInput.getAttribute('value');
    }

    setGuidInput = function (guid) {
        this.guidInput.sendKeys(guid);
    }

    getGuidInput = function () {
        return this.guidInput.getAttribute('value');
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
