module.exports = {
  preset: 'ts-jest',
  testEnvironment: 'jsdom',
  roots: [
    "<rootDir>/src"
  ],
  transform: {
    '.(css|less)$': '<rootDir>/src/style-mock.ts'
  },
  collectCoverageFrom: [
    "**/*.{ts,tsx}",
    "!**/node_modules/**",
    "!**/coverage/**",
    "!**/index.tsx",
    "!**/setupTests.ts",
    "!**/aws-exports.ts",
    "!**/style-mock.ts",
    "!**/Starter.tsx",
    "!**/@types/aws/aws-exports.d.ts",

  ],
  coveragePathIgnorePatterns: [
    "/node_modules/",
    "package.json",
    "package-lock.json"
  ],
  coverageThreshold: {
    "global": {
      "branches": 90,
      "lines": 90,
      "statements": 90,
      "functions": 90
    }
  }
};