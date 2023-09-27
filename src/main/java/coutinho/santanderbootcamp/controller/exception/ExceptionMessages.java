package coutinho.santanderbootcamp.controller.exception;

public enum ExceptionMessages {
    USER_ID_ALREADY_EXISTS("This User ID already exists"),
    USER_NOT_FOUND_BY_ID("User not found by this ID"),
    ACCOUNT_ALREADY_EXISTS("This account number already exists"),
    CARD_NUMBER_ALREADY_EXISTS("This card number already exists"),
    FEATURE_NOT_FOUND("Feature code not found"),
    FEATURE_NOT_FOUND_BY_ID("Feature ID not found"),
    NEWS_NOT_FOUND("News code not found");

    private String description;

    ExceptionMessages(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
