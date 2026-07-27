package com.cutlet.ffmpeg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FFmpegUtil {

    private static void runFFmpeg(String... command) throws Exception {

        ProcessBuilder pb = new ProcessBuilder(command);

        pb.redirectErrorStream(true);

        Process process = pb.start();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream())
        );

        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        int exitCode = process.waitFor();

        if (exitCode != 0) {
            throw new RuntimeException(
                    "FFmpeg failed with exit code " + exitCode
            );
        }
    }

    public static void convert(String input, String output) throws Exception {

        runFFmpeg(
                "ffmpeg",
                "-y",
                "-i",
                input,
                output
        );

    }

    public static void extractAudio(String input, String output) throws Exception {

        runFFmpeg(
                "ffmpeg",
                "-y",
                "-i",
                input,
                "-vn",
                output
        );

    }

}