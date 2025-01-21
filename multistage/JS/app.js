const express = require("express");
const app = express();
app.use(express.json());
require("dotenv").config();
const PORT = process.env.PORT || 5555;

app.get("/", (req, res) => {
  res.json({
    message: `Hello, World! Node.js Server is running on http://localhost:${PORT}`,
  });
});

app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
