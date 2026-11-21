module order.processing {
    requires static lombok;
    requires net.datafaker;

    exports com.ordermanagement.processing.model;
    exports com.ordermanagement.processing.service;
    exports com.ordermanagement.processing.factory;
    exports com.ordermanagement.processing.exception;
}
