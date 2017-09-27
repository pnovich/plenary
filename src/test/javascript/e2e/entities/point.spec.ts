import { browser, element, by, $ } from 'protractor';
import { NavBarPage } from './../page-objects/jhi-page-objects';
const path = require('path');

describe('Point e2e test', () => {

    let navBarPage: NavBarPage;
    let pointDialogPage: PointDialogPage;
    let pointComponentsPage: PointComponentsPage;
    const fileToUpload = '../../../../main/webapp/content/images/logo-jhipster.png';
    const absolutePath = path.resolve(__dirname, fileToUpload);
    

    beforeAll(() => {
        browser.get('/');
        browser.waitForAngular();
        navBarPage = new NavBarPage();
        navBarPage.getSignInPage().autoSignInUsing('admin', 'admin');
        browser.waitForAngular();
    });

    it('should load Points', () => {
        navBarPage.goToEntity('point');
        pointComponentsPage = new PointComponentsPage();
        expect(pointComponentsPage.getTitle()).toMatch(/plenaryErpApp.point.home.title/);

    });

    it('should load create Point dialog', () => {
        pointComponentsPage.clickOnCreateButton();
        pointDialogPage = new PointDialogPage();
        expect(pointDialogPage.getModalTitle()).toMatch(/plenaryErpApp.point.home.createOrEditLabel/);
        pointDialogPage.close();
    });

    it('should create and save Points', () => {
        pointComponentsPage.clickOnCreateButton();
        pointDialogPage.setNameInput('name');
        expect(pointDialogPage.getNameInput()).toMatch('name');
        pointDialogPage.setFullNameInput('fullName');
        expect(pointDialogPage.getFullNameInput()).toMatch('fullName');
        pointDialogPage.setGuidInput('guid');
        expect(pointDialogPage.getGuidInput()).toMatch('guid');
        pointDialogPage.setHouseNumberInput('houseNumber');
        expect(pointDialogPage.getHouseNumberInput()).toMatch('houseNumber');
        pointDialogPage.setAddressInput('address');
        expect(pointDialogPage.getAddressInput()).toMatch('address');
        pointDialogPage.setLongitudeInput('5');
        expect(pointDialogPage.getLongitudeInput()).toMatch('5');
        pointDialogPage.setLatitudeInput('5');
        expect(pointDialogPage.getLatitudeInput()).toMatch('5');
        pointDialogPage.setServiceTimeInput('5');
        expect(pointDialogPage.getServiceTimeInput()).toMatch('5');
        pointDialogPage.setCommentInput('comment');
        expect(pointDialogPage.getCommentInput()).toMatch('comment');
        pointDialogPage.setCreatedByInput('createdBy');
        expect(pointDialogPage.getCreatedByInput()).toMatch('createdBy');
        pointDialogPage.setCreatedDateInput(12310020012301);
        expect(pointDialogPage.getCreatedDateInput()).toMatch('2001-12-31T02:30');
        pointDialogPage.setLastModifiedByInput('lastModifiedBy');
        expect(pointDialogPage.getLastModifiedByInput()).toMatch('lastModifiedBy');
        pointDialogPage.setLastModifiedDateInput(12310020012301);
        expect(pointDialogPage.getLastModifiedDateInput()).toMatch('2001-12-31T02:30');
        pointDialogPage.companySelectLastOption();
        pointDialogPage.branchSelectLastOption();
        pointDialogPage.countrySelectLastOption();
        pointDialogPage.regionSelectLastOption();
        pointDialogPage.settlementSelectLastOption();
        pointDialogPage.streetSelectLastOption();
        pointDialogPage.save();
        expect(pointDialogPage.getSaveButton().isPresent()).toBeFalsy();
    }); 

    afterAll(() => {
        navBarPage.autoSignOut();
    });
});

export class PointComponentsPage {
    createButton = element(by.css('.jh-create-entity'));
    title = element.all(by.css('jhi-point div h2 span')).first();

    clickOnCreateButton() {
        return this.createButton.click();
    }

    getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class PointDialogPage {
    modalTitle = element(by.css('h4#myPointLabel'));
    saveButton = element(by.css('.modal-footer .btn.btn-primary'));
    closeButton = element(by.css('button.close'));
    nameInput = element(by.css('input#field_name'));
    fullNameInput = element(by.css('input#field_fullName'));
    guidInput = element(by.css('input#field_guid'));
    houseNumberInput = element(by.css('input#field_houseNumber'));
    addressInput = element(by.css('input#field_address'));
    longitudeInput = element(by.css('input#field_longitude'));
    latitudeInput = element(by.css('input#field_latitude'));
    serviceTimeInput = element(by.css('input#field_serviceTime'));
    commentInput = element(by.css('input#field_comment'));
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

    setHouseNumberInput = function (houseNumber) {
        this.houseNumberInput.sendKeys(houseNumber);
    }

    getHouseNumberInput = function () {
        return this.houseNumberInput.getAttribute('value');
    }

    setAddressInput = function (address) {
        this.addressInput.sendKeys(address);
    }

    getAddressInput = function () {
        return this.addressInput.getAttribute('value');
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

    setServiceTimeInput = function (serviceTime) {
        this.serviceTimeInput.sendKeys(serviceTime);
    }

    getServiceTimeInput = function () {
        return this.serviceTimeInput.getAttribute('value');
    }

    setCommentInput = function (comment) {
        this.commentInput.sendKeys(comment);
    }

    getCommentInput = function () {
        return this.commentInput.getAttribute('value');
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
