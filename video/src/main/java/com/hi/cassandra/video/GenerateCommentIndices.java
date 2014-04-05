package com.hi.cassandra.video;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.UUID;

/**
 * TODO
 * The code is not exactly correct. It should generate different comments for different videos/users, and instead
 * it repeats the user/videoid. However, the timestamp is different, and this saves the db and allows it to write 
 * to different in each given row.
 * 
 * @author Mark Kerzner
 */
public class GenerateCommentIndices {

    public static void main(String argv[]) {
        if (argv.length != 2) {
            System.out.println("Arguments: videos, average-comments-per-video");
            System.exit(0);
        }
        GenerateCommentIndices generator = new GenerateCommentIndices();
        int nVideos = Integer.parseInt(argv[0]);
        int nAverageComments = Integer.parseInt(argv[1]);

        try {
            generator.generate(nVideos, nAverageComments);
        } catch (Exception e) {
            System.out.println("Problem writig files: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    private void generate(int nVideos, int nAverageComments) throws IOException {
        new File(Util.ROOT_DIR).mkdirs();
        Charset charset = Charset.forName("US-ASCII");
        if (nAverageComments < 1) {
            nAverageComments = 1;
        }
        String byUserFile = Util.ROOT_DIR + "/" + Util.COMMENTS_BY_USER;
        String byVideoFile = Util.ROOT_DIR + "/" + Util.COMMENTS_BY_VIDEO;
        Util util = new Util();
        new File(byUserFile).delete();
        new File(byVideoFile).delete();
        Files.append("use videodb;\n", new File(byUserFile), charset);
        Files.append("use videodb;\n", new File(byVideoFile), charset);
        for (int u = 1; u <= nVideos; ++u) {
            StringBuilder videoPart = new StringBuilder();
            StringBuilder userPart = new StringBuilder();
            videoPart.append("INSERT INTO comments_by_video (videoid, username, comment_ts, comment) VALUES (");
            userPart.append("INSERT INTO comments_by_user (username, videoid, comment_ts, comment) VALUES (");
            // "perm" data
            String videoid = UUID.randomUUID().toString();
            String user = util.generateName();
            // form data part of CQL
            videoPart.append(videoid).append(",'").append(user).append("','");
            userPart.append("'").append(user).append("',").append(videoid).append(",'");
            // calculate the actual number of comments for this video
            // here we take an average between 1 and 2 * average, but 
            // TODO use a more realistic distribution, with long tail
            int nComments = util.generateInt(1, 2 * nAverageComments);
            for (int c = 0; c < nComments; ++c) {
                // date the comment back up to a year  
                String commentDate = Util.dateFormat.format(new Date().getTime() - util.generateInt(0, 365) * Util.DAY_MILS);
                StringBuilder commentPart = new StringBuilder();
                String comment = util.generateName();
                commentPart.append(commentDate).append("','").append(comment).append("');").append("\n");
                Files.append(videoPart.toString() + commentPart.toString(), new File(byVideoFile), charset);
                Files.append(userPart.toString() + commentPart.toString(), new File(byUserFile), charset);
            }
        }
        System.out.println("Generated file: " + byUserFile);
        System.out.println("Generated file: " + byVideoFile);
    }
}
