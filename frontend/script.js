
const API_BASE = 'http://localhost:8080/api/code';

async function submitCode() {
    
    const fileInput = document.getElementById('fileInput');
    const codeArea = document.getElementById('codeArea');
    const analyzeBtn = document.getElementById('analyzeBtn');

    let code  = codeArea.value;
    let filename = 'pasted_code.txt';

    if(fileInput && fileInput.files.length > 0) {
        const file = fileInput.files[0];
        code = await file.text();
        filename = file.name;
    }
    
    if(!code.trim()) {
        alert('Please enter code or upload a file');
        return;
    }

    analyzeBtn.disabled = true;
    analyzeBtn.innerText = 'Uploading...';


    // call backend API

    try {
        // const reponse = await fetch(`${API_BASE}/upload`, {
        //     method: 'POST',
        //     headers: { 'Content-Type': 'application/json'},
        //     body: JSON.stringify({
        //         filename: filename,
        //         code: code
        //     })
        // });

        // if(reponse.ok) {
        //     // do something
        // } else {
        //     alert('Upload failed');
        // }
    } catch(e) {
        console.error(e);
        alert('Error connection to server');
    } finally {
        analyzeBtn.disabled = false;
        analyzeBtn.innerText = 'Analyze Code';
    }


}