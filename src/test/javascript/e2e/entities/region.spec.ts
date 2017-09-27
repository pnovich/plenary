import { browser, element, by, $ } from 'protractor';
import { NavBarPage } from './../page-objects/jhi-page-objects';
const path = require('path');

describe('Region e2e test', () => {

    let navBarPage: NavBarPage;
    let regionDialogPage: RegionDialogPage;
    let regionComponentsPage: RegionComponentsPage;
    const fileToUpload = '../../../../main/webapp/content/images/logo-jhipster.png';
    const absolutePath = path.resolve(__dirname, fileToUpload);
    

    beforeAll(() => {
        browser.get('/');
        browser.waitForAngular();
        navBarPage = new NavBarPage();
        navBarPage.getSignInPage().autoSignInUsing('admin', 'admin');
        browser.waitForAngular();
    });

    it('should load Regions', () => {
        navBarPage.goToEntity('region');
        regionComponentsPage = new RegionComponentsPage();
        expect(regionComponentsPage.getTitle()).toMatch(/plenaryErpApp.region.home.title/);

    });

    it('should load create Region dialog', () => {
        regionComponentsPage.clickOnCreateButton();
        regionDialogPage = new RegionDialogPage();
        expect(regionDialogPage.getModalTitle()).toMatch(/plenaryErpApp.region.home.createOrEditLabel/);
        regionDialogPage.close();
    });

    it('should create and save Regions', () => {
        regionComponentsPage.clickOnCreateButton();
        regionDialogPage.setNameInput('name');
        expect(regionDialogPage.getNameInput()).toMatch('name');
        regionDialogPage.setFullNameInput('fullName');
        expect(regionDialogPage.getFullNameInput()).toMatch('fullName');
        regionDialogPage.setGuidInput('guid');
        expect(regionDialogPage.getGuidInput()).toMatch('guid');
        regionDialogPage.setCreatedByInput('createdBy');
        expect(regionDialogPage.getCreatedByInput()).toMatch('createdBy');
        regionDialogPage.setCreatedDateInput(12310020012301);
        expect(regionDialogPage.getCreatedDateInput()).toMatch('2001-12-31T02:30');
        regionDialogPage.setLastModifiedByInput('lastModifiedBy');
        expect(regionDialogPage.getLastModifiedByInput()).toMatch('lastModifiedBy');
        regionDialogPage.setLastModifiedDateInput(12310020012301);
        expect(regionDialogPage.getLastModifiedDateInput()).toMatch('2001-12-31T02:30');
        regionDialogPage.countrySelectLastOption();
        regionDialogPage.save();
        expect(regionDialogPage.getSaveButton().isPresent()).toBeFalsy();
    }); 

    afterAll(() => {
        navBarPage.autoSignOut();
    });
});

export class RegionComponentsPage {
    createButton = element(by.css('.jh-create-entity'));
    title = element.all(by.css('jhi-region div h2 span')).first();

    clickOnCreateButton() {
        return this.createButton.click();
    }

    getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class RegionDialogPage {
    modalTitle = element(by.css('h4#myRegionLabel'));
    saveButton = element(by.css('.modal-footer .btn.btn-primary'));
    closeButton = element(by.css('button.close'));
    nameInput = element(by.css('input#field_name'));
    fullNameInput = element(by.css('input#field_fullName'));
    guidInput = element(by.css('input#field_guid'));
    createdByInput = element(by.css('input#field_createdBy'));
    createdDateInput = element(by.css('input#field_createdDate'));
    lastModifiedByInput = element(by.css('input#field_lastModifiedBy'));
    lastModifiedDateInput = element(by.css('input#field_lastModifiedDate'));
    countrySelect = element(by.css('select#field_country'));

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
