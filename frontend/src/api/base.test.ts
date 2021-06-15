describe("Base url", () => {
  const OLD_ENV = process.env;

  beforeEach(() => {
    jest.resetModules();
    process.env = { ...OLD_ENV };
    delete process.env.NODE_ENV;
  });

  afterAll(() => {
    process.env = OLD_ENV;
  });

  it("should return localhost when environment is Development", () => {
    //ACT
    const config = require("./base").default;

    //ASSERT
    expect(config).toBe("http://localhost:9090");
  });

  it("should return heroku url when environment is Production", () => {
    //ARRANGE
    process.env = { NODE_ENV: "production" };

    //ACT
    const config = require("./base").default;

    //ASSERT
    expect(config).toBe("https://proxy-cinema-booking.herokuapp.com/https://cinema-booking-backend.herokuapp.com");
  });
});
