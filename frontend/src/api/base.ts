const proxy = "https://cors-anywhere.herokuapp.com/";
const herokuapp = "https://cinema-booking-backend.herokuapp.com";
const localhost = "http://localhost:9090";
const baseURL =
  process.env.NODE_ENV === "production" ? `${proxy}${herokuapp}` : localhost;
export default baseURL;
