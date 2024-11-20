class FileManager {
    constructor() {
        this.files = [];  // Array to store file metadata
    }

    // Simulate file creation
    createFile(fileName, fileContent) {
        return new Promise((resolve, reject) => {
            try {
                const file = {
                    name: fileName,
                    content: fileContent,
                    timestamp: new Date()
                };
                this.files.push(file);
                resolve(`File '${fileName}' created successfully!`);
            } catch (error) {
                reject(`Error creating file: ${error.message}`);
            }
        });
    }

    // Simulate file upload
    uploadFile(fileName, fileContent) {
        return new Promise((resolve, reject) => {
            try {
                const file = {
                    name: fileName,
                    content: fileContent,
                    timestamp: new Date()
                };
                this.files.push(file);
                resolve(`File '${fileName}' uploaded successfully!`);
            } catch (error) {
                reject(`Error uploading file: ${error.message}`);
            }
        });
    }

    // Simulate file download
    downloadFile(fileName) {
        return new Promise((resolve, reject) => {
            const file = this.files.find(f => f.name === fileName);
            if (file) {
                resolve(file.content);
            } else {
                reject(`File '${fileName}' not found!`);
            }
        });
    }

    // Simulate file deletion
    deleteFile(fileName) {
        return new Promise((resolve, reject) => {
            const fileIndex = this.files.findIndex(f => f.name === fileName);
            if (fileIndex !== -1) {
                this.files.splice(fileIndex, 1);
                resolve(`File '${fileName}' deleted successfully!`);
            } else {
                reject(`File '${fileName}' not found!`);
            }
        });
    }

    // Show list of file names
    showFileNames() {
        return new Promise((resolve, reject) => {
            if (this.files.length > 0) {
                const fileNames = this.files.map(f => f.name);
                resolve(fileNames);
            } else {
                reject("No files available.");
            }
        });
    }
}

// Create a FileManager instance
const fileManager = new FileManager();

// Create a file
function createFile() {
    const fileName = document.getElementById('fileName').value;
    const fileContent = document.getElementById('fileContent').value;

    if (fileName && fileContent) {
        fileManager.createFile(fileName, fileContent)
            .then(message => showMessage(message))
            .catch(error => showMessage(error));
    } else {
        showMessage("File name and content cannot be empty.");
    }
}

// Upload a file
function uploadFile() {
    const fileInput = document.getElementById('fileUpload');
    const file = fileInput.files[0];

    if (file) {
        const reader = new FileReader();
        reader.onload = () => {
            fileManager.uploadFile(file.name, reader.result)
                .then(message => showMessage(message))
                .catch(error => showMessage(error));
        };
        reader.readAsText(file);
    } else {
        showMessage("Please select a file.");
    }
}

// Download a file
function downloadFile() {
    const fileName = prompt("Enter the name of the file to download:");
    fileManager.downloadFile(fileName)
        .then(content => {
            const blob = new Blob([content], { type: "text/plain" });
            const link = document.createElement('a');
            link.href = URL.createObjectURL(blob);
            link.download = fileName;
            link.click();
        })
        .catch(error => showMessage(error));
}

// Delete a file
function deleteFile() {
    const fileName = prompt("Enter the name of the file to delete:");
    fileManager.deleteFile(fileName)
        .then(message => showMessage(message))
        .catch(error => showMessage(error));
}

// Show all file names
function showFileNames() {
    fileManager.showFileNames()
        .then(fileNames => {
            showMessage(fileNames.join(", "));
        })
        .catch(error => showMessage(error));
}

// Show message in the output div
function showMessage(message) {
    document.getElementById('output').textContent = message;
}
