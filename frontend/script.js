async function checkData() {

    const input = document.getElementById("dataInput");
    const result = document.getElementById("result");

    const data = input.value.trim();

    if (!data) {
        result.className = "result false-positive";
        result.innerHTML = "❌ Invalid / Empty Data";
        return;
    }

    result.className = "result";
    result.innerHTML = "⏳ Checking data...";

    try {

        const response = await fetch(
            `http://localhost:8080/api/data?data=${encodeURIComponent(data)}`,
            {
                method: "POST"
            }
        );

        if (!response.ok) {
            throw new Error("Server error");
        }

        const resultData = await response.json();

        if (resultData.status === "UNIQUE") {

            result.className = "result unique";
            result.innerHTML = "✅ Data is UNIQUE";

        } else if (resultData.status === "REDUNDANT") {

            result.className = "result redundant";
            result.innerHTML = "⚠️ Data is REDUNDANT";

        } else if (resultData.status === "FALSE_POSITIVE") {

            result.className = "result false-positive";
            result.innerHTML = "❌ Invalid / Empty Data";
        }

    } catch (error) {

        console.error(error);

        result.className = "result false-positive";
        result.innerHTML = "❌ Unable to connect to backend.";
    }
}