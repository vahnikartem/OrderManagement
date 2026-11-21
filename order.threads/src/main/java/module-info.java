module order.threads {
    requires order.processing;
    requires order.storage;

    exports com.ordermanagement.threads.service;
}
