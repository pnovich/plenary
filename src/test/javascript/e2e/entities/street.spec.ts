import { browser, element, by, $ } from 'protractor';
import { NavBarPage } from './../page-objects/jhi-page-objects';
const path = require('path');

describe('Street e2e test', () => {

    let navBarPage: NavBarPage;
    let streetDialogPage: StreetDialogPage;
    let streetComponentsPage: StreetComponentsPage;
    const fileToUpload = '../../../../main/webapp/content/images/logo-jhipster.png';
    const absolutePath = path.resolve(__dirname, fileToUpload);
    

    beforeAll(() => {
        browser.get('/');
        browser.waitForAngular();
        navBarPage = new NavBarPage();
        navBarPage.getSignInPage().autoSignInUsing('admin', 'admin');
        browser.waitForAngular();
    });

    it('should load Streets', () => {
        navBarPage.goToEntity('street');
        streetComponentsPage = new StreetComponentsPage();
        expect(streetComponentsPage.getTitle()).toMatch(/plenaryErpApp.street.home.title/);

    });

    it('should load create Street dialog', () => {
        streetComponentsPage.clickOnCreateButton();
        streetDialogPage = new StreetDialogPage();
        expect(streetDialogPage.getModalTitle()).toMatch(/plenaryErpApp.street.home.createOrEditLabel/);
        streetDialogPage.close();
    });

    it('should create and save Streets', () => {
        streetComponentsPage.clickOnCreateButton();
        streetDialogPage.setNameInput('name');
        expect(streetDialogPage.getNameInput()).toMatch('name');
        streetDialogPage.setFullNameInput('fullName');
        expect(streetDialogPage.getFullNameInput()).toMatch('fullName');
        streetDialogPage.setGuidInput('guid');
        expect(streetDialogPage.getGuidInput()).toMatch('guid');
        streetDialogPage.setCreatedByInput('createdBy');
        expect(streetDialogPage.getCreatedByInput()).toMatch('createdBy');
        streetDialogPage.setCreatedDateInput(12310020012301);
        expect(streetDialogPage.getCreatedDateInput()).toMatch('2001-12-31T02:30');
        streetDialogPage.setLastModifiedByInput('lastModifiedBy');
        expect(streetDialogPage.getLastModifiedByInput()).toMatch('lastModifiedBy');
        streetDialogPage.setLastModifiedDateInput(12310020012301);
        expect(streetDialogPage.getLastModifiedDateInput()).toMatch('2001-12-31T02:30');
        streetDialogPage.settlementSelectLastOption();
        streetDialogPage.save();
        expect(streetDialogPage.getSaveButton().isPresent()).toBeFalsy();
    }); 

    afterAll(() => {
        navBarPage.autoSignOut();
    });
});

export class StreetComponentsPage {
    createButton = element(by.css('.jh-create-entity'));
    title = element.all(by.css('jhi-street div h2 span')).first();

    clickOnCreateButton() {
        return this.createButton.click();
    }

    getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class StreetDialogPage {
    modalTitle = element(by.css('h4#myStreetLabel'));
    saveButton = element(by.css('.modal-footer .btn.btn-primary'));
    closeButton = element(by.css('button.close'));
    nameInput = element(by.css('input#field_name'));
    fullNameInput = element(by.css('input#field_fullName'));
    guidInput = element(by.css('input#field_guid'));
    createdByInput = element(by.css('input#field_createdBy'));
    createdDateInput = element(by.css('input#field_createdDate'));
    lastModifiedByInput = element(by.css('input#field_lastModifiedBy'));
    lastModifiedDateInput = element(by.css('input#field_lastModifiedDate'));
    settlementSelect = element(by.css('select#field_settlement'));

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
