package utils;

public enum Locators {

    LOGIN_BTN("locator");

    private String locator;

    Locators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
