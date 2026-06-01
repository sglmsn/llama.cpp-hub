package com.mark.test.tools;

import java.io.IOException;
import java.nio.file.Path;

import org.mark.llamacpp.crawler.NettyHttpUtils;
import org.mark.llamacpp.crawler.UserAgentUtils;

/**
 * Standalone test for DownloadToFileRequest redirect handling.
 * <p>
 * Usage:
 * <pre>
 *   java ...DownloadRedirectTest [url] [output-path]
 * </pre>
 * Defaults:
 *   URL:     https://huggingface.co/unsloth/Qwen3.5-0.8B-GGUF/resolve/main/Qwen3.5-0.8B-Q4_0.gguf?download=true
 *   Output:  cache/test-redirect-download.gguf
 */
public class DownloadRedirectTest {

    private static final String DEFAULT_URL =
            "https://huggingface.co/unsloth/Qwen3.5-0.8B-GGUF/resolve/main/Qwen3.5-0.8B-Q4_0.gguf?download=true";
    private static final String DEFAULT_OUTPUT = "cache/test-redirect-download.gguf";

    public static void main(String[] args) throws IOException {
        String url = args.length >= 1 ? args[0] : DEFAULT_URL;
        String output = args.length >= 2 ? args[1] : DEFAULT_OUTPUT;

        System.out.println("URL:    " + url);
        System.out.println("Output: " + output);
        System.out.println();

        long start = System.currentTimeMillis();

        try {
            NettyHttpUtils.downloadToFile(url)
                    .targetFile(Path.of(output))
                    .connectTimeout(30)
                    .readTimeout(600)
                    .header("User-Agent", UserAgentUtils.random())
                    .header("Accept", "*/*")
                    .progressListener((downloaded, total) -> {
                        double pct = total > 0 ? (double) downloaded / total * 100 : -1;
                        String totalStr = total > 0 ? formatBytes(total) : "???";
                        System.out.printf("\rProgress: %s / %s  (%.1f%%)", formatBytes(downloaded), totalStr, pct);
                    })
                    .execute();

            long elapsed = System.currentTimeMillis() - start;
            System.out.println("\nDownload completed in " + elapsed + "ms");
            System.out.println("Saved to: " + Path.of(output).toAbsolutePath());

        } catch (IOException e) {
            long elapsed = System.currentTimeMillis() - start;
            System.err.println("\nDownload failed after " + elapsed + "ms: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static String formatBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.1f KB", bytes / 1024.0);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.1f MB", bytes / (1024.0 * 1024));
        return String.format("%.2f GB", bytes / (1024.0 * 1024 * 1024));
    }
}
