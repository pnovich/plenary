import { browser, element, by, $ } from 'protractor';
import { NavBarPage } from './../page-objects/jhi-page-objects';
const path = require('path');

describe('Driver e2e test', () => {

    let navBarPage: NavBarPage;
    let driverDialogPage: DriverDialogPage;
    let driverComponentsPage: DriverComponentsPage;
    const fileToUpload = '../../../../main/webapp/content/images/logo-jhipster.png';
    const absolutePath = path.resolve(__dirname, fileToUpload);
    

    beforeAll(() => {
        browser.get('/');
        browser.waitForAngular();
        navBarPage = new NavBarPage();
        navBarPage.getSignInPage().autoSignInUsing('admin', 'admin');
        browser.waitForAngular();
    });

    it('should load Drivers', () => {
        navBarPage.goToEntity('driver');
        driverComponentsPage = new DriverComponentsPage();
        expect(driverComponentsPage.getTitle()).toMatch(/plenaryErpApp.driver.home.title/);

    });

    it('should load create Driver dialog', () => {
        driverComponentsPage.clickOnCreateButton();
        driverDialogPage = new DriverDialogPage();
        expect(driverDialogPage.getModalTitle()).toMatch(/plenaryErpApp.driver.home.createOrEditLabel/);
        driverDialogPage.close();
    });

    it('should create and save Drivers', () => {
        driverComponentsPage.clickOnCreateButton();
        driverDialogPage.setFirstNameInput('firstName');
        expect(driverDialogPage.getFirstNameInput()).toMatch('firstName');
        driverDialogPage.setLastNameInput('lastName');
        expect(driverDialogPage.getLastNameInput()).toMatch('lastName');
        driverDialogPage.setMiddleNameInput('middleName');
        expect(driverDialogPage.getMiddleNameInput()).toMatch('middleName');
        driverDialogPage.setFullNameInput('fullName');
        expect(driverDialogPage.getFullNameInput()).toMatch('fullName');
        driverDialogPage.setGuidInput('guid');
        expect(driverDialogPage.getGuidInput()).toMatch('guid');
        driverDialogPage.setPhoneInput('phone');
        expect(driverDialogPage.getPhoneInput()).toMatch('phone');
        driverDialogPage.setEmailInput('email');
        expect(driverDialogPage.getEmailInput()).toMatch('email');
        driverDialogPage.setCreatedByInput('createdBy');
        expect(driverDialogPage.getCreatedByInput()).toMatch('createdBy');
        driverDialogPage.setCreatedDateInput(12310020012301);
        expect(driverDialogPage.getCreatedDateInput()).toMatch('2001-12-31T02:30');
        driverDialogPage.setLastModifiedByInput('lastModifiedBy');
        expect(driverDialogPage.getLastModifiedByInput()).toMatch('lastModifiedBy');
        driverDialogPage.setLastModifiedDateInput(12310020012301);
        expect(driverDialogPage.getLastModifiedDateInput()).toMatch('2001-12-31T02:30');
        driverDialogPage.companySelectLastOption();
        driverDialogPage.branchSelectLastOption();
        driverDialogPage.save();
        expect(driverDialogPage.getSaveButton().isPresent()).toBeFalsy();
    }); 

    afterAll(() => {
        navBarPage.autoSignOut();
    });
});

export class DriverComponentsPage {
    createButton = element(by.css('.jh-create-entity'));
    title = element.all(by.css('jhi-driver div h2 span')).first();

    clickOnCreateButton() {
        return this.createButton.click();
    }

    getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class DriverDialogPage {
    modalTitle = element(by.css('h4#myDriverLabel'));
    saveButton = element(by.css('.modal-footer .btn.btn-primary'));
    closeButton = element(by.css('button.close'));
    firstNameInput = element(by.css('input#field_firstName'));
    lastNameInput = element(by.css('input#field_lastName'));
    middleNameInput = element(by.css('input#field_middleName'));
    fullNameInput = element(by.css('input#field_fullName'));
    guidInput = element(by.css('input#field_guid'));
    phoneInput = element(by.css('input#field_phone'));
    emailInput = element(by.css('input#field_email'));
    createdByInput = element(by.css('input#field_createdBy'));
    createdDateInput = element(by.css('input#field_createdDate'));
    lastModifiedByInput = element(by.css('input#field_lastModifiedBy'));
    lastModifiedDateInput = element(by.css('input#field_lastModifiedDate'));
    companySelect = element(by.css('select#field_company'));
    branchSelect = element(by.css('select#field_branch'));

    getModalTitle() {
        return this.modalTitle.getAttribute('jhiTranslate');
    }

    setFirstNameInput = function (firstName) {
        this.firstNameInput.sendKeys(firstName);
    }

    getFirstNameInput = function () {
        return this.firstNameInput.getAttribute('value');
    }

    setLastNameInput = function (lastName) {
        this.lastNameInput.sendKeys(lastName);
    }

    getLastNameInput = function () {
        return this.lastNameInput.getAttribute('value');
    }

    setMiddleNameInput = function (middleName) {
        this.middleNameInput.sendKeys(middleName);
    }

    getMiddleNameInput = function () {
        return this.middleNameInput.getAttribute('value');
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

    setPhoneInput = function (phone) {
        this.phoneInput.sendKeys(phone);
    }

    getPhoneInput = function () {
        return this.phoneInput.getAttribute('value');
    }

    setEmailInput = function (email) {
        this.emailInput.sendKeys(email);
    }

    getEmailInput = function () {
        return this.emailInput.getAttribute('value');
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
