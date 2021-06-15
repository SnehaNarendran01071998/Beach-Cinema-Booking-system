const proxy = "https://cryptic-ocean-50781.herokuapp.com/";
const herokuapp = "cinema-booking-backend.herokuapp.com";
const localhost = "http://localhost:9090";
const baseURL =
  process.env.NODE_ENV === "production" ? `${herokuapp}` : localhost;
export default baseURL;
