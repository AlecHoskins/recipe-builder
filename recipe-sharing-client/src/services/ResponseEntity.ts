interface ResponseEntity<T> {
    status: number; // HTTP status code
    data: T;       // Response data of type T
    message?: string; // Optional message field
}