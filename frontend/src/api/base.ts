const baseURL =
  process.env.NODE_ENV === "production"
    ? "https://cinema-booking-backend.herokuapp.com"
    : "http://localhost:9090";
export default baseURL;
