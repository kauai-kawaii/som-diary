function fetchMusicByYearAndMonth(selectedYear, selectedMonth) {
    // Encode the author to ensure the URL is valid even if the author name contains special characters
    // Construct the URL with query parameters
    const hostURL = 'http://localhost:8081';
    const url = `${hostURL}/insight?selectedYear=${selectedYear}&selectedMonth=${selectedMonth}`;

    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log(`Track ID in ${selectedMonth}-${selectedYear}:`, data);
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}

// Example usage
fetchMusicByYearAndMonth(2024, 2); // Fetch posts written in February 2024
