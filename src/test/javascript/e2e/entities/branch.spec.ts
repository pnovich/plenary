import { browser, element, by, $ } from 'protractor';
import { NavBarPage } from './../page-objects/jhi-page-objects';
const path = require('path');

describe('Branch e2e test', () => {

    let navBarPage: NavBarPage;
    let branchDialogPage: BranchDialogPage;
    let branchComponentsPage: BranchComponentsPage;
    const fileToUpload = '../../../../main/webapp/content/images/logo-jhipster.png';
    const absolutePath = path.resolve(__dirname, fileToUpload);
    

    beforeAll(() => {
        browser.get('/');
        browser.waitForAngular();
        navBarPage = new NavBarPage();
        navBarPage.getSignInPage().autoSignInUsing('admin', 'admin');
        browser.waitForAngular();
    });

    it('should load Branches', () => {
        navBarPage.goToEntity('branch');
        branchComponentsPage = new BranchComponentsPage();
        expect(branchComponentsPage.getTitle()).toMatch(/plenaryErpApp.branch.home.title/);

    });

    it('should load create Branch dialog', () => {
        branchComponentsPage.clickOnCreateButton();
        branchDialogPage = new BranchDialogPage();
        expect(branchDialogPage.getModalTitle()).toMatch(/plenaryErpApp.branch.home.createOrEditLabel/);
        branchDialogPage.close();
    });

    it('should create and save Branches', () => {
        branchComponentsPage.clickOnCreateButton();
        branchDialogPage.setNameInput('name');
        expect(branchDialogPage.getNameInput()).toMatch('name');
        branchDialogPage.setFullNameInput('fullName');
        expect(branchDialogPage.getFullNameInput()).toMatch('fullName');
        branchDialogPage.setEmailInput('email');
        expect(branchDialogPage.getEmailInput()).toMatch('email');
        branchDialogPage.setPhoneInput('phone');
        expect(branchDialogPage.getPhoneInput()).toMatch('phone');
        branchDialogPage.setAddressInput('address');
        expect(branchDialogPage.getAddressInput()).toMatch('address');
        branchDialogPage.setCreatedByInput('createdBy');
        expect(branchDialogPage.getCreatedByInput()).toMatch('createdBy');
        branchDialogPage.setCreatedDateInput(12310020012301);
        expect(branchDialogPage.getCreatedDateInput()).toMatch('2001-12-31T02:30');
        branchDialogPage.setLastModifiedByInput('lastModifiedBy');
        expect(branchDialogPage.getLastModifiedByInput()).toMatch('lastModifiedBy');
        branchDialogPage.setLastModifiedDateInput(12310020012301);
        expect(branchDialogPage.getLastModifiedDateInput()).toMatch('2001-12-31T02:30');
        branchDialogPage.companySelectLastOption();
        branchDialogPage.save();
        expect(branchDialogPage.getSaveButton().isPresent()).toBeFalsy();
    }); 

    afterAll(() => {
        navBarPage.autoSignOut();
    });
});

export class BranchComponentsPage {
    createButton = element(by.css('.jh-create-entity'));
    title = element.all(by.css('jhi-branch div h2 span')).first();

    clickOnCreateButton() {
        return this.createButton.click();
    }

    getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class BranchDialogPage {
    modalTitle = element(by.css('h4#myBranchLabel'));
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
    companySelect = element(by.css('select#field_company'));

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
