import { browser, element, by, $ } from 'protractor';
import { NavBarPage } from './../page-objects/jhi-page-objects';
const path = require('path');

describe('Status e2e test', () => {

    let navBarPage: NavBarPage;
    let statusDialogPage: StatusDialogPage;
    let statusComponentsPage: StatusComponentsPage;
    const fileToUpload = '../../../../main/webapp/content/images/logo-jhipster.png';
    const absolutePath = path.resolve(__dirname, fileToUpload);
    

    beforeAll(() => {
        browser.get('/');
        browser.waitForAngular();
        navBarPage = new NavBarPage();
        navBarPage.getSignInPage().autoSignInUsing('admin', 'admin');
        browser.waitForAngular();
    });

    it('should load Statuses', () => {
        navBarPage.goToEntity('status');
        statusComponentsPage = new StatusComponentsPage();
        expect(statusComponentsPage.getTitle()).toMatch(/plenaryErpApp.status.home.title/);

    });

    it('should load create Status dialog', () => {
        statusComponentsPage.clickOnCreateButton();
        statusDialogPage = new StatusDialogPage();
        expect(statusDialogPage.getModalTitle()).toMatch(/plenaryErpApp.status.home.createOrEditLabel/);
        statusDialogPage.close();
    });

    it('should create and save Statuses', () => {
        statusComponentsPage.clickOnCreateButton();
        statusDialogPage.setNameInput('name');
        expect(statusDialogPage.getNameInput()).toMatch('name');
        statusDialogPage.setFullNameInput('fullName');
        expect(statusDialogPage.getFullNameInput()).toMatch('fullName');
        statusDialogPage.setGuidInput('guid');
        expect(statusDialogPage.getGuidInput()).toMatch('guid');
        statusDialogPage.setCreatedByInput('createdBy');
        expect(statusDialogPage.getCreatedByInput()).toMatch('createdBy');
        statusDialogPage.setCreatedDateInput(12310020012301);
        expect(statusDialogPage.getCreatedDateInput()).toMatch('2001-12-31T02:30');
        statusDialogPage.setLastModifiedByInput('lastModifiedBy');
        expect(statusDialogPage.getLastModifiedByInput()).toMatch('lastModifiedBy');
        statusDialogPage.setLastModifiedDateInput(12310020012301);
        expect(statusDialogPage.getLastModifiedDateInput()).toMatch('2001-12-31T02:30');
        statusDialogPage.save();
        expect(statusDialogPage.getSaveButton().isPresent()).toBeFalsy();
    }); 

    afterAll(() => {
        navBarPage.autoSignOut();
    });
});

export class StatusComponentsPage {
    createButton = element(by.css('.jh-create-entity'));
    title = element.all(by.css('jhi-status div h2 span')).first();

    clickOnCreateButton() {
        return this.createButton.click();
    }

    getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class StatusDialogPage {
    modalTitle = element(by.css('h4#myStatusLabel'));
    saveButton = element(by.css('.modal-footer .btn.btn-primary'));
    closeButton = element(by.css('button.close'));
    nameInput = element(by.css('input#field_name'));
    fullNameInput = element(by.css('input#field_fullName'));
    guidInput = element(by.css('input#field_guid'));
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
