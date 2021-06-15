describe("Base url", () => {
  const OLD_ENV = process.env;

  beforeEach(() => {
    jest.resetModules(); // Most important - it clears the cache
    process.env = { ...OLD_ENV }; // Make a copy
    delete process.env.NODE_ENV;
  });

  afterAll(() => {
    process.env = OLD_ENV; // Restore old environment
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
    expect(config).toBe("https://cinema-booking-backend.herokuapp.com");
  });
});
