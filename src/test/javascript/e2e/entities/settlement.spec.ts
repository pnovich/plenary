import { browser, element, by, $ } from 'protractor';
import { NavBarPage } from './../page-objects/jhi-page-objects';
const path = require('path');

describe('Settlement e2e test', () => {

    let navBarPage: NavBarPage;
    let settlementDialogPage: SettlementDialogPage;
    let settlementComponentsPage: SettlementComponentsPage;
    const fileToUpload = '../../../../main/webapp/content/images/logo-jhipster.png';
    const absolutePath = path.resolve(__dirname, fileToUpload);
    

    beforeAll(() => {
        browser.get('/');
        browser.waitForAngular();
        navBarPage = new NavBarPage();
        navBarPage.getSignInPage().autoSignInUsing('admin', 'admin');
        browser.waitForAngular();
    });

    it('should load Settlements', () => {
        navBarPage.goToEntity('settlement');
        settlementComponentsPage = new SettlementComponentsPage();
        expect(settlementComponentsPage.getTitle()).toMatch(/plenaryErpApp.settlement.home.title/);

    });

    it('should load create Settlement dialog', () => {
        settlementComponentsPage.clickOnCreateButton();
        settlementDialogPage = new SettlementDialogPage();
        expect(settlementDialogPage.getModalTitle()).toMatch(/plenaryErpApp.settlement.home.createOrEditLabel/);
        settlementDialogPage.close();
    });

    it('should create and save Settlements', () => {
        settlementComponentsPage.clickOnCreateButton();
        settlementDialogPage.setNameInput('name');
        expect(settlementDialogPage.getNameInput()).toMatch('name');
        settlementDialogPage.setFullNameInput('fullName');
        expect(settlementDialogPage.getFullNameInput()).toMatch('fullName');
        settlementDialogPage.setGuidInput('guid');
        expect(settlementDialogPage.getGuidInput()).toMatch('guid');
        settlementDialogPage.setCreatedByInput('createdBy');
        expect(settlementDialogPage.getCreatedByInput()).toMatch('createdBy');
        settlementDialogPage.setCreatedDateInput(12310020012301);
        expect(settlementDialogPage.getCreatedDateInput()).toMatch('2001-12-31T02:30');
        settlementDialogPage.setLastModifiedByInput('lastModifiedBy');
        expect(settlementDialogPage.getLastModifiedByInput()).toMatch('lastModifiedBy');
        settlementDialogPage.setLastModifiedDateInput(12310020012301);
        expect(settlementDialogPage.getLastModifiedDateInput()).toMatch('2001-12-31T02:30');
        settlementDialogPage.regionSelectLastOption();
        settlementDialogPage.save();
        expect(settlementDialogPage.getSaveButton().isPresent()).toBeFalsy();
    }); 

    afterAll(() => {
        navBarPage.autoSignOut();
    });
});

export class SettlementComponentsPage {
    createButton = element(by.css('.jh-create-entity'));
    title = element.all(by.css('jhi-settlement div h2 span')).first();

    clickOnCreateButton() {
        return this.createButton.click();
    }

    getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class SettlementDialogPage {
    modalTitle = element(by.css('h4#mySettlementLabel'));
    saveButton = element(by.css('.modal-footer .btn.btn-primary'));
    closeButton = element(by.css('button.close'));
    nameInput = element(by.css('input#field_name'));
    fullNameInput = element(by.css('input#field_fullName'));
    guidInput = element(by.css('input#field_guid'));
    createdByInput = element(by.css('input#field_createdBy'));
    createdDateInput = element(by.css('input#field_createdDate'));
    lastModifiedByInput = element(by.css('input#field_lastModifiedBy'));
    lastModifiedDateInput = element(by.css('input#field_lastModifiedDate'));
    regionSelect = element(by.css('select#field_region'));

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
