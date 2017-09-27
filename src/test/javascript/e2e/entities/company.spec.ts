import { browser, element, by, $ } from 'protractor';
import { NavBarPage } from './../page-objects/jhi-page-objects';
const path = require('path');

describe('Company e2e test', () => {

    let navBarPage: NavBarPage;
    let companyDialogPage: CompanyDialogPage;
    let companyComponentsPage: CompanyComponentsPage;
    const fileToUpload = '../../../../main/webapp/content/images/logo-jhipster.png';
    const absolutePath = path.resolve(__dirname, fileToUpload);
    

    beforeAll(() => {
        browser.get('/');
        browser.waitForAngular();
        navBarPage = new NavBarPage();
        navBarPage.getSignInPage().autoSignInUsing('admin', 'admin');
        browser.waitForAngular();
    });

    it('should load Companies', () => {
        navBarPage.goToEntity('company');
        companyComponentsPage = new CompanyComponentsPage();
        expect(companyComponentsPage.getTitle()).toMatch(/plenaryErpApp.company.home.title/);

    });

    it('should load create Company dialog', () => {
        companyComponentsPage.clickOnCreateButton();
        companyDialogPage = new CompanyDialogPage();
        expect(companyDialogPage.getModalTitle()).toMatch(/plenaryErpApp.company.home.createOrEditLabel/);
        companyDialogPage.close();
    });

    it('should create and save Companies', () => {
        companyComponentsPage.clickOnCreateButton();
        companyDialogPage.setNameInput('name');
        expect(companyDialogPage.getNameInput()).toMatch('name');
        companyDialogPage.setFullNameInput('fullName');
        expect(companyDialogPage.getFullNameInput()).toMatch('fullName');
        companyDialogPage.setEmailInput('email');
        expect(companyDialogPage.getEmailInput()).toMatch('email');
        companyDialogPage.setPhoneInput('phone');
        expect(companyDialogPage.getPhoneInput()).toMatch('phone');
        companyDialogPage.setAddressInput('address');
        expect(companyDialogPage.getAddressInput()).toMatch('address');
        companyDialogPage.setCreatedByInput('createdBy');
        expect(companyDialogPage.getCreatedByInput()).toMatch('createdBy');
        companyDialogPage.setCreatedDateInput(12310020012301);
        expect(companyDialogPage.getCreatedDateInput()).toMatch('2001-12-31T02:30');
        companyDialogPage.setLastModifiedByInput('lastModifiedBy');
        expect(companyDialogPage.getLastModifiedByInput()).toMatch('lastModifiedBy');
        companyDialogPage.setLastModifiedDateInput(12310020012301);
        expect(companyDialogPage.getLastModifiedDateInput()).toMatch('2001-12-31T02:30');
        companyDialogPage.save();
        expect(companyDialogPage.getSaveButton().isPresent()).toBeFalsy();
    }); 

    afterAll(() => {
        navBarPage.autoSignOut();
    });
});

export class CompanyComponentsPage {
    createButton = element(by.css('.jh-create-entity'));
    title = element.all(by.css('jhi-company div h2 span')).first();

    clickOnCreateButton() {
        return this.createButton.click();
    }

    getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class CompanyDialogPage {
    modalTitle = element(by.css('h4#myCompanyLabel'));
    saveButton = element(by.css('.modal-footer .btn.btn-primary'));
    closeButton = element(by.css('button.close'));
    nameInput = element(by.css('input#field_name'));
    fullNameInput = element(by.css('input#field_fullName'));
    emailInput = element(by.css('input#field_email'));
    phoneInput = element(by.css('input#field_phone'));
    addressInput = element(by.css('input#field_address'));
    createdByInput = element(by.css('input#field_createdBy'));
    createdDateInput = element(by.css('input#field_createdDate'));
    lastModifiedByInput = element(by.css('input#field_lastModifiedBy'));
    lastModifiedDateInput = element(by.css('input#field_lastModifiedDate'));

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

    setEmailInput = function (email) {
        this.emailInput.sendKeys(email);
    }

    getEmailInput = function () {
        return this.emailInput.getAttribute('value');
    }

    setPhoneInput = function (phone) {
        this.phoneInput.sendKeys(phone);
    }

    getPhoneInput = function () {
        return this.phoneInput.getAttribute('value');
    }

    setAddressInput = function (address) {
        this.addressInput.sendKeys(address);
    }

    getAddressInput = function () {
        return this.addressInput.getAttribute('value');
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
