self.addEventListener('message', function(e) {
  self.postMessage("Hello, " + e.data);
}, false);

